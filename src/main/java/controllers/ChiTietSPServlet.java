package controllers;

import domain_model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.*;



import java.io.IOException;
import java.util.UUID;


@WebServlet({
        "/chi-tiet-san-pham/index",    // GET
        "/chi-tiet-san-pham/create",   // GET
        "/chi-tiet-san-pham/edit",     // GET
        "/chi-tiet-san-pham/delete",   // GET
        "/chi-tiet-san-pham/store",    // POST
        "/chi-tiet-san-pham/update",   // POST
})
public class ChiTietSPServlet extends HttpServlet {
    ChiTietSPRepository chiTietSPRepository;
    MauSacRepository mauSacRepository;
    SanPhamRepository sanPhamRepository;
    NsxRepository nsxRepository;
    DongSPRepository dongSPRepository;

    public  ChiTietSPServlet() {
        chiTietSPRepository = new ChiTietSPRepository();
        mauSacRepository = new MauSacRepository();
        sanPhamRepository = new SanPhamRepository();
        nsxRepository = new NsxRepository();
        dongSPRepository = new DongSPRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("DSCTSP",this.chiTietSPRepository.findAll());
        request.setAttribute("view", "/views/chi_tiet_san_pham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("dsms",this.mauSacRepository.findAll());
        request.setAttribute("dssp",this.sanPhamRepository.findAll());
        request.setAttribute("dsnxs",this.nsxRepository.findAll());
        request.setAttribute("dsdsp",this.dongSPRepository.findAll());
        request.setAttribute("view", "/views/chi_tiet_san_pham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChiTietSP sp = this.chiTietSPRepository.findByMa(ma);
        request.setAttribute("dsms",this.mauSacRepository.findAll());
        request.setAttribute("dssp",this.sanPhamRepository.findAll());
        request.setAttribute("dsnxs",this.nsxRepository.findAll());
        request.setAttribute("dsdsp",this.dongSPRepository.findAll());
        request.setAttribute("kh", sp);
        request.setAttribute("view", "/views/chi_tiet_san_pham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChiTietSP sp = this.chiTietSPRepository.findByMa(ma);
        this.chiTietSPRepository.delete(sp);
        response.sendRedirect("/ASM_war_exploded/chi-tiet-san-pham/index");
    }
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String namBH = request.getParameter("namBH");
        String moTa = request.getParameter("moTa");
        String soLuongTon = request.getParameter("soLuongTon");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");

        HttpSession session = request.getSession();
        if (namBH.equals("") || moTa.equals("") || soLuongTon.equals("") || giaNhap.equals("")|| giaBan.equals("")) {
            session.setAttribute("errorMessage7", "Vui Lòng Không Để Trống Thông Tin");
            response.sendRedirect("/ASM_war_exploded/khach-hang/create");
        } else {
            ChiTietSP chiTietSPDomain = new ChiTietSP();
            try {
                BeanUtils.populate(chiTietSPDomain, request.getParameterMap());
            } catch (Exception e) {
                e.printStackTrace();
            }
            String idMauSac = request.getParameter("idMauSac");
            String idSP = request.getParameter("idSP");
            String idNsx = request.getParameter("idNsx");
            String idDongSP = request.getParameter("idDongSP");
            UUID idMS = UUID.fromString(idMauSac);
            UUID idSP2 = UUID.fromString(idSP);
            UUID idNsx2 = UUID.fromString(idNsx);
            UUID idDongSP2 = UUID.fromString(idDongSP);
            MauSac DomainModelMs = this.mauSacRepository.findById(idMS);
            SanPham DomainModelSP = this.sanPhamRepository.findById(idSP2);
            NSX DomainModelNSx = this.nsxRepository.findById(idNsx2);
            DongSP DomainModelDSp = this.dongSPRepository.findById(idDongSP2);
            chiTietSPDomain.setMs(DomainModelMs);
            chiTietSPDomain.setSp(DomainModelSP);
            chiTietSPDomain.setNsx(DomainModelNSx);
            chiTietSPDomain.setDsp(DomainModelDSp);

            this.chiTietSPRepository.insert(chiTietSPDomain);
            response.sendRedirect("/ASM_war_exploded/chi-tiet-san-pham/index");
        }
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChiTietSP vm = this.chiTietSPRepository.findByMa(ma);
        try {
            BeanUtils.populate(vm, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String idMauSac = request.getParameter("idMauSac");
        String idSP = request.getParameter("idSP");
        String idNsx = request.getParameter("idNsx");
        String idDongSP = request.getParameter("idDongSP");
        UUID idMS = UUID.fromString(idMauSac);
        UUID idSP2 = UUID.fromString(idSP);
        UUID idNsx2 = UUID.fromString(idNsx);
        UUID idDongSP2 = UUID.fromString(idDongSP);
        MauSac DomainModelMs = this.mauSacRepository.findById(idMS);
        SanPham DomainModelSP = this.sanPhamRepository.findById(idSP2);
        NSX DomainModelNSx = this.nsxRepository.findById(idNsx2);
        DongSP DomainModelDSp = this.dongSPRepository.findById(idDongSP2);
        vm.setMs(DomainModelMs);
        vm.setSp(DomainModelSP);
        vm.setNsx(DomainModelNSx);
        vm.setDsp(DomainModelDSp);
        this.chiTietSPRepository.update(vm);

        response.sendRedirect("/ASM_war_exploded/chi-tiet-san-pham/index");
    }
}
