package net.morena.esa.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.morena.esa.sevice.IngredientService;

import java.io.IOException;

@WebServlet(value = "/ingredient/delete")
public class IngredientDeleteServlet extends HttpServlet {

    @EJB
    private IngredientService ingredientService;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ingredientService.deleteById(Long.parseLong(request.getParameter("id")));
        response.sendRedirect(request.getContextPath() + "/ingredient");
    }

}