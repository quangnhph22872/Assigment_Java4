package controllers;

import domain_model.DongSP;
import domain_model.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.DongSPRepository;
import view_model.QLDongSP;
import view_model.QLKhachHang;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/dong-san-pham/index",    // GET
        "/dong-san-pham/create",   // GET
        "/dong-san-pham/edit",     // GET
        "/dong-san-pham/delete",   // GET
        "/dong-san-pham/store",    // POST
        "/dong-san-pham/update",   // POST
})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dspRepo;

    public DongSPServlet(){
        this.dspRepo = new DongSPRepository();
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
        DongSP domainModelDSP = this.dspRepo.findByMa(ma);
        request.setAttribute("x", domainModelDSP);
        request.setAttribute("view", "/views/dongsp/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP domainModelDSP = this.dspRepo.findByMa(ma);
        this.dspRepo.delete(domainModelDSP);
        response.sendRedirect("/ASM_war_exploded/dong-san-pham/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachDSP", this.dspRepo.findAll());
        request.setAttribute("view", "/views/dongsp/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/dongsp/create.jsp");
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
            response.sendRedirect("/ASM_war_exploded/dong-san-pham/index");
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
                session.setAttribute("errorMessage3", "Vui Lòng Không Để Trống Thông Tin");
                response.sendRedirect("/ASM_war_exploded/dong-san-pham/create");
            } else {
                DongSP domainModelDSP = new DongSP();
                BeanUtils.populate(domainModelDSP, request.getParameterMap());
                this.dspRepo.insert(domainModelDSP);
                response.sendRedirect("/ASM_war_exploded/dong-san-pham/index");
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
            DongSP domainModelDSP = this.dspRepo.findByMa(ma);
            BeanUtils.populate(domainModelDSP, request.getParameterMap());
            this.dspRepo.update(domainModelDSP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ASM_war_exploded/dong-san-pham/index");
    }
}

