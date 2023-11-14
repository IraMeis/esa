package net.morena.esa.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.morena.esa.sevice.DishService;

import java.io.IOException;

@WebServlet(value = "/dish/create")
public class DishCreateServlet extends HttpServlet {

    @EJB
    private DishService dishService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        dishService.setGetRequestForDish(request, response);
        getServletContext().getRequestDispatcher("/dish-create.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        dishService.create(request, response);
        response.sendRedirect(request.getContextPath() + "/dish");
    }

}