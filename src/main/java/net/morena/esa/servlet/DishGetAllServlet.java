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
import java.util.List;

@WebServlet(value = "/dish")
public class DishGetAllServlet extends HttpServlet {

    @EJB
    private DishService dishService;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Dish> dishList = dishService.getAll();
        request.setAttribute("dishes", dishList);
        getServletContext().getRequestDispatcher("/dish.jsp").forward(request, response);
    }

}