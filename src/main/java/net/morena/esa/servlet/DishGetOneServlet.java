package net.morena.esa.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.morena.esa.entity.Dish;
import net.morena.esa.sevice.DishService;

import java.io.IOException;

@WebServlet(value = "/dish/view")
public class DishGetOneServlet extends HttpServlet {

    @EJB
    private DishService dishService;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Dish d = dishService.getById(Long.parseLong(request.getParameter("id")));
        request.setAttribute("o", d);
        getServletContext().getRequestDispatcher("/dish-view.jsp").forward(request, response);
    }

}