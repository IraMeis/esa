package net.morena.esa.sevice;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.morena.esa.entity.Ingredient;
import net.morena.esa.repository.IngredientRepo;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Stateless
public class IngredientService {

    @EJB
    private IngredientRepo ingredientRepo;

    public void save(Ingredient o) {
        ingredientRepo.save(o);
    }

    public List<Ingredient> getAll() {
        return ingredientRepo.getAll();
    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        Ingredient o = new Ingredient();
        o.setName(request.getParameter("name"));
        save(o);
    }

    public Ingredient getById(Long id) {
        return ingredientRepo.getById(id);
    }

    public void deleteById(Long id) {
        ingredientRepo.deleteById(id);
    }
}