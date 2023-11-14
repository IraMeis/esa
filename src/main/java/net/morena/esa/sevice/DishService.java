package net.morena.esa.sevice;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.morena.esa.entity.DictUnit;
import net.morena.esa.entity.Dish;
import net.morena.esa.entity.Ingredient;
import net.morena.esa.entity.IngredientForDish;
import net.morena.esa.repository.DictUnitRepo;
import net.morena.esa.repository.DishRepo;
import net.morena.esa.repository.IngredientForDishRepo;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateless
public class DishService {

    @EJB
    private IngredientService ingredientService;

    @EJB
    private DishRepo dishRepo;

    @EJB
    private DictUnitRepo dictUnitRepo;

    @EJB
    private IngredientForDishRepo ingredientForDishRepo;

    public void save(Dish o) {
        dishRepo.save(o);
    }

    public List<Dish> getAll() {
        return dishRepo.getAll();
    }

    public Dish getById(Long id) {
        return dishRepo.getById(id);
    }

    public void setGetRequestForDish(HttpServletRequest request, HttpServletResponse response) {
        List<Ingredient> allIng = ingredientService.getAll();
        request.setAttribute("allIngredients", allIng);
        List<DictUnit> allUnit = dictUnitRepo.getAll();
        request.setAttribute("allUnits", allUnit);
        request.setAttribute("ingCount", request.getParameter("ingCount"));
    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");

        Dish dish = new Dish();
        Set<IngredientForDish> ingredientForDishes = new HashSet<>();

        dish.setName(request.getParameter("name"));
        dish.setPortion(Double.parseDouble(request.getParameter("portion")));
        dish.setRecipe(request.getParameter("recipe"));
        dish.setTimeMin(request.getParameter("timeMin"));
        dish.setTimeMax(request.getParameter("timeMax"));
        save(dish);

        int i = 0;
        do {
            IngredientForDish ingredientForDish = new IngredientForDish();
            ingredientForDish.setDishRef(dish.getUniqueId());
            ingredientForDish.setIngredient(
                    ingredientService.getById(
                            Long.parseLong(request.getParameter("ingredient" + i))));
            ingredientForDish.setVolume(
                            Double.parseDouble(request.getParameter("volume" + i)));
            ingredientForDish.setUnit(
                    dictUnitRepo.getByCode(
                            Long.parseLong(request.getParameter("unit" + i))));
            ingredientForDishRepo.save(ingredientForDish);
            ingredientForDishes.add(ingredientForDish);
            i += 1;
        }
        while (request.getParameter("ingredient" + i) != null);
        dish.setIngredientForDish(ingredientForDishes);
    }

    public void deleteById(Long id) {
       dishRepo.deleteById(id);
    }
}