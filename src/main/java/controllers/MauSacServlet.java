package controllers;

import domain_model.MauSac;
import domain_model.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.MauSacRepository;
import view_model.QLMauSac;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/mau-sac/index",    // GET
        "/mau-sac/create",   // GET
        "/mau-sac/edit",     // GET
        "/mau-sac/delete",   // GET
        "/mau-sac/store",    // POST
        "/mau-sac/update",   // POST
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msRepo;

    public MauSacServlet(){
        this.msRepo = new MauSacRepository();
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
        MauSac domainModelMS = this.msRepo.findByMa(ma);
        request.setAttribute("ms", domainModelMS);
        request.setAttribute("view", "/views/mau_sac/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac domainModelMS = this.msRepo.findByMa(ma);
        this.msRepo.delete(domainModelMS);
        response.sendRedirect("/ASM_war_exploded/mau-sac/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachMS", this.msRepo.findAll());
        request.setAttribute("view", "/views/mau_sac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/mau_sac/create.jsp");
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
            response.sendRedirect("/ASM_war_exploded/mau-sac/index");
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
                session.setAttribute("errorMessage4", "Vui Lòng Không Để Trống Thông Tin");
                response.sendRedirect("/ASM_war_exploded/mau-sac/create");
            } else {
                MauSac domainModelMS = new MauSac();
                BeanUtils.populate(domainModelMS, request.getParameterMap());
                this.msRepo.insert(domainModelMS);
                response.sendRedirect("/ASM_war_exploded/mau-sac/index");
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
            MauSac domainModelMS = this.msRepo.findByMa(ma);
            BeanUtils.populate(domainModelMS, request.getParameterMap());
            this.msRepo.update(domainModelMS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ASM_war_exploded/mau-sac/index");
    }
}
