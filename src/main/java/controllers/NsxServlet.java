package controllers;

import domain_model.NSX;
import domain_model.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.NsxRepository;
import view_model.QLNSX;

import java.io.IOException;

@WebServlet({
        "/nha-san-xuat/index",    // GET
        "/nha-san-xuat/create",   // GET
        "/nha-san-xuat/edit",     // GET
        "/nha-san-xuat/delete",   // GET
        "/nha-san-xuat/store",    // POST
        "/nha-san-xuat/update",   // POST
})
public class NsxServlet extends HttpServlet {
    private NsxRepository nsxRepo;

    public NsxServlet(){
        this.nsxRepo = new NsxRepository();
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
        NSX domainModelNSX = this.nsxRepo.findByMa(ma);
        request.setAttribute("x", domainModelNSX);
        request.setAttribute("view", "/views/nsx/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX domainModelNSX = this.nsxRepo.findByMa(ma);
        this.nsxRepo.delete(domainModelNSX);
        response.sendRedirect("/ASM_war_exploded/nha-san-xuat/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachNSX", this.nsxRepo.findAll());
        request.setAttribute("view", "/views/nsx/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/nsx/create.jsp");
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
            response.sendRedirect("/ASM_war_exploded/nha-san-xuat/index");
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
                session.setAttribute("errorMessage5", "Vui Lòng Không Để Trống Thông Tin");
                response.sendRedirect("/ASM_war_exploded/nha-san-xuat/create");
            } else {
                NSX domainModelNSX = new NSX();
                BeanUtils.populate(domainModelNSX, request.getParameterMap());
                this.nsxRepo.insert(domainModelNSX);
                response.sendRedirect("/ASM_war_exploded/nha-san-xuat/index");
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
            NSX domainModelNSX = this.nsxRepo.findByMa(ma);
            BeanUtils.populate(domainModelNSX, request.getParameterMap());
            this.nsxRepo.update(domainModelNSX);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ASM_war_exploded/nha-san-xuat/index");
    }
}
