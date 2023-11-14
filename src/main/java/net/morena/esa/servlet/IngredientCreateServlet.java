package net.morena.esa.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.morena.esa.sevice.IngredientService;

import java.io.IOException;

@WebServlet(value = "/ingredient/create")
public class IngredientCreateServlet extends HttpServlet {

    @EJB
    private IngredientService ingredientService;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/ingredient-create.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ingredientService.create(request, response);
        response.sendRedirect(request.getContextPath() + "/ingredient");
    }


}