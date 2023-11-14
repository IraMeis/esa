package net.morena.esa.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.morena.esa.sevice.DishService;

import java.io.IOException;

@WebServlet(value = "/dish/delete")
public class DishDeleteServlet extends HttpServlet {

    @EJB
    private DishService dishService;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        dishService.deleteById(Long.parseLong(request.getParameter("id")));
        response.sendRedirect(request.getContextPath() + "/dish");
    }

}