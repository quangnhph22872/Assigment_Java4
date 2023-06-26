package controllers;

import domain_model.KhachHang;
import domain_model.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.SanPhamRepository;
import view_model.QLSanPham;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/san-pham/index",    // GET
        "/san-pham/create",   // GET
        "/san-pham/edit",     // GET
        "/san-pham/delete",   // GET
        "/san-pham/store",    // POST
        "/san-pham/update",   // POST
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository spRepo;

    public SanPhamServlet(){
        this.spRepo = new SanPhamRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham domainModelSP = this.spRepo.findByMa(ma);
        request.setAttribute("sp", domainModelSP);
        request.setAttribute("view", "/views/san_pham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham domainModelSP = this.spRepo.findByMa(ma);
        this.spRepo.delete(domainModelSP);
        response.sendRedirect("/ASM_war_exploded/san-pham/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachSP", this.spRepo.findAll());
        request.setAttribute("view", "/views/san_pham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/san_pham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/ASM_war_exploded/san-pham/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            HttpSession session = request.getSession();
            if (ma.equals("") || ten.equals("")) {
                session.setAttribute("errorMessage6", "Vui Lòng Không Để Trống Thông Tin");
                response.sendRedirect("/ASM_war_exploded/san-pham/create");
            } else {
                SanPham domainModelSP = new SanPham();
                BeanUtils.populate(domainModelSP, request.getParameterMap());
                this.spRepo.insert(domainModelSP);
                response.sendRedirect("/ASM_war_exploded/san-pham/index");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            SanPham domainModelSP = this.spRepo.findByMa(ma);
            BeanUtils.populate(domainModelSP, request.getParameterMap());
            this.spRepo.update(domainModelSP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ASM_war_exploded/san-pham/index");
    }
}

