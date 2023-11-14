package net.morena.esa.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.morena.esa.entity.Ingredient;
import net.morena.esa.sevice.IngredientService;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/ingredient")
public class IngredientGetAllServlet extends HttpServlet {

    @EJB
    private IngredientService ingredientService;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Ingredient> ingredientList = ingredientService.getAll();
        request.setAttribute("ingredients", ingredientList);
        getServletContext().getRequestDispatcher("/ingredient.jsp").forward(request, response);
    }

}