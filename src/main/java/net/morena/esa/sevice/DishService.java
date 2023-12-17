package net.morena.esa.sevice;


import lombok.RequiredArgsConstructor;
import net.morena.esa.dto.DishDTO;
import net.morena.esa.dto.IngredientForDishCreationDTO;
import net.morena.esa.dto.SimpleIngredientDTO;
import net.morena.esa.entity.Dish;
import net.morena.esa.entity.IngredientForDish;
import net.morena.esa.repository.DictUnitRepo;
import net.morena.esa.repository.DishRepo;
import net.morena.esa.repository.IngredientForDishRepo;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DishService {

    private final IngredientService ingredientService;
    private final DishRepo dishRepo;
    private final DictUnitRepo dictUnitRepo;
    private final IngredientForDishRepo ingredientForDishRepo;

    public List<Dish> getAll() {
        return dishRepo.findAllByIsDeletedFalse();
    }

    public Dish getById(Long id) {
        return dishRepo.findOneByUniqueIdAndIsDeletedFalse(id);
    }

    public void deleteById(Long id) {
        dishRepo.deleteById(id);
    }

    public void setParamsForDish(Model model, int ingCount) {
        model.addAttribute("allIngredients", ingredientService.getAll());
        model.addAttribute("allUnits", dictUnitRepo.findAllByIsDeletedFalse());
        model.addAttribute("dish", new Dish());
        IngredientForDishCreationDTO ing = new IngredientForDishCreationDTO();
        for (int i = 0; i < ingCount; ++i)
            ing.addSimpleIngredient(SimpleIngredientDTO.builder().build());
        model.addAttribute("ingDTO", ing);
    }

    public void create(Dish dish, IngredientForDishCreationDTO dto) {
        dishRepo.saveAndFlush(dish);

        Set<IngredientForDish> ingredientForDishes = new HashSet<>();
        for (int i = 0; i < dto.getIngredients().size(); ++i){
            IngredientForDish ingredientForDish = new IngredientForDish();
            ingredientForDish.setDishRef(dish.getUniqueId());
            ingredientForDish.setIngredient(
                    ingredientService.getById(dto.getIngredients().get(i).getIngredientId()));
            ingredientForDish.setVolume(dto.getIngredients().get(i).getVolume());
            ingredientForDish.setUnit(
                    dictUnitRepo.getByCodeAndIsDeletedFalse(dto.getIngredients().get(i).getUnitCode()));
            ingredientForDishRepo.save(ingredientForDish);
            ingredientForDishes.add(ingredientForDish);
        }
        dish.setIngredientForDish(ingredientForDishes);
    }

    public void create(DishDTO dto) {
        Dish dish = Dish.builder()
                .name(dto.getName())
                .portion(dto.getPortion())
                .recipe(dto.getRecipe())
                .timeMax(dto.getTimeMax())
                .timeMin(dto.getTimeMin())
                .build();
        dishRepo.saveAndFlush(dish);

        Set<IngredientForDish> ingredientForDishes = new HashSet<>();
        for (int i = 0; i < dto.getIngredients().size(); ++i){
            IngredientForDish ingredientForDish = new IngredientForDish();
            ingredientForDish.setDishRef(dish.getUniqueId());
            ingredientForDish.setIngredient(
                    ingredientService.getById(dto.getIngredients().get(i).getIngredientId()));
            ingredientForDish.setVolume(dto.getIngredients().get(i).getVolume());
            ingredientForDish.setUnit(
                    dictUnitRepo.getByCodeAndIsDeletedFalse(dto.getIngredients().get(i).getUnitCode()));
            ingredientForDishRepo.save(ingredientForDish);
            ingredientForDishes.add(ingredientForDish);
        }
        dish.setIngredientForDish(ingredientForDishes);
    }

}