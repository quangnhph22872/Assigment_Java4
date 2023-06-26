package controllers;

import domain_model.ChucVu;
import domain_model.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChucVuRepository;
import view_model.QLChucVu;
import view_model.QLKhachHang;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/chuc-vu/index",    // GET
        "/chuc-vu/create",   // GET
        "/chuc-vu/edit",     // GET
        "/chuc-vu/delete",   // GET
        "/chuc-vu/store",    // POST
        "/chuc-vu/update",   // POST
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository cvRepo = new ChucVuRepository();;

//    public ChucVuServlet(){
//        this.cvRepo = new ChucVuRepository();
//
//    }

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
        ChucVu domainModelCV = this.cvRepo.findByMa(ma);
        request.setAttribute("cv", domainModelCV);
        request.setAttribute("view", "/views/chuc_vu/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu domainModelCV = this.cvRepo.findByMa(ma);
        this.cvRepo.delete(domainModelCV);
        response.sendRedirect("/ASM_war_exploded/chuc-vu/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachCV", this.cvRepo.findAll());
        request.setAttribute("view", "/views/chuc_vu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/chuc_vu/create.jsp");
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
            response.sendRedirect("/ASM_war_exploded/chuc-vu/index");
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
                session.setAttribute("errorMessage", "Vui Lòng Không Để Trống Thông Tin");
                response.sendRedirect("/ASM_war_exploded/chuc-vu/create");
            } else {
                ChucVu domainModelCV = new ChucVu();
                BeanUtils.populate(domainModelCV, request.getParameterMap());
                this.cvRepo.insert(domainModelCV);
                response.sendRedirect("/ASM_war_exploded/chuc-vu/index");
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
            ChucVu domainModelCV = this.cvRepo.findByMa(ma);
            BeanUtils.populate(domainModelCV, request.getParameterMap());
            this.cvRepo.update(domainModelCV);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ASM_war_exploded/chuc-vu/index");
    }
}
