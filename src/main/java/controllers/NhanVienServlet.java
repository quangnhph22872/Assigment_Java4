package controllers;

import domain_model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChucVuRepository;
import repository.CuaHangRepository;
import repository.NhanVienRepository;
import view_model.QLKhachHang;
import view_model.QLNhanVien;


import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

@WebServlet({
        "/nhan-vien/index",    // GET
        "/nhan-vien/create",   // GET
        "/nhan-vien/edit",     // GET
        "/nhan-vien/delete",   // GET
        "/nhan-vien/store",    // POST
        "/nhan-vien/update",   // POST
})
public class NhanVienServlet extends HttpServlet{
    NhanVienRepository nhanVienRepository;
    ChucVuRepository chucVuRepository;
    CuaHangRepository cuaHangRepository;

    public NhanVienServlet(){
        nhanVienRepository = new NhanVienRepository();
        chucVuRepository = new ChucVuRepository();
        cuaHangRepository = new CuaHangRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        }else if(uri.contains("edit")){
            this.edit(request,response);
        }else if(uri.contains("delete")){
            this.delete(request,response);
        }else{
            this.index(request,response);
        }
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("DSNhanVien",this.nhanVienRepository.findAll());
        request.setAttribute("view", "/views/nhan_vien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("dscv",this.chucVuRepository.findAll());
        request.setAttribute("dsch",this.cuaHangRepository.findAll());
        request.setAttribute("view", "/views/nhan_vien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        request.setAttribute("dscv",this.chucVuRepository.findAll());
        request.setAttribute("dsch",this.cuaHangRepository.findAll());
        NhanVien nv = this.nhanVienRepository.findByMa(ma);
        request.setAttribute("nv",nv);
        request.setAttribute("view", "/views/nhan_vien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = this.nhanVienRepository.findByMa(ma);
        this.nhanVienRepository.delete(nv);
        response.sendRedirect("/ASM_war_exploded/nhan-vien/index");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.index(request, response);
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String ho = request.getParameter("ho");
        String tenDem = request.getParameter("tenDem");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");

        HttpSession session = request.getSession();
        if (ma.equals("") || ten.equals("") || ho.equals("") || tenDem.equals("")|| ngaySinh.equals("") || sdt.equals("") || diaChi.equals("") || matKhau.equals("")) {
            session.setAttribute("errorMessage8", "Vui Lòng Không Để Trống Thông Tin");
            response.sendRedirect("/ASM_war_exploded/nhan-vien/create");
        } else {
            QLNhanVien nv = new QLNhanVien();
            try {
                BeanUtils.populate(nv, request.getParameterMap());
            } catch (Exception e) {
                e.printStackTrace();
            }
            NhanVien DomainModelNv = new NhanVien();
            String maCv = request.getParameter("idCV");
            String maCh = request.getParameter("idCH");
            UUID idCV = UUID.fromString(maCv);
            UUID idCH = UUID.fromString(maCh);
            ChucVu DomainModelCv = this.chucVuRepository.findById(idCV);
            CuaHang DomainModelCh = this.cuaHangRepository.findById(idCH);

            DomainModelNv.setMa(nv.getMa());
            DomainModelNv.setTen(nv.getTen());
            DomainModelNv.setTenDem(nv.getTenDem());
            DomainModelNv.setHo(nv.getHo());
            DomainModelNv.setGioiTinh(nv.getGioiTinh());
            DomainModelNv.setNgaySinh(nv.getNgaySinh());
            DomainModelNv.setDiaChi(nv.getDiaChi());
            DomainModelNv.setSdt(nv.getSdt());
            DomainModelNv.setMatKhau(nv.getMatKhau());
            DomainModelNv.setCuaHang(DomainModelCh);
            DomainModelNv.setCv(DomainModelCv);
            DomainModelNv.setTrangThai(nv.getTrangThai());
            try {
                this.nhanVienRepository.insert(DomainModelNv);
                response.sendRedirect("/ASM_war_exploded/nhan-vien/index");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = this.nhanVienRepository.findByMa(ma);
        try {
            BeanUtils.populate(nv,request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String maCv = request.getParameter("idCV");
        String maCh = request.getParameter("idCH");
        UUID idCV = UUID.fromString(maCv);
        UUID idCH = UUID.fromString(maCh);
        ChucVu DomainModelCv = this.chucVuRepository.findById(idCV);
        CuaHang DomainModelCh = this.cuaHangRepository.findById(idCH);
        nv.setCv(DomainModelCv);
        nv.setCuaHang(DomainModelCh);
        nhanVienRepository.update(nv);
        response.sendRedirect("/ASM_war_exploded/nhan-vien/index");
    }
}
