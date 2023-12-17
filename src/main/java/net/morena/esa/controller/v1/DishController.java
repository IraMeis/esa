package net.morena.esa.controller.v1;


import lombok.RequiredArgsConstructor;
import net.morena.esa.dto.IngredientForDishCreationDTO;
import net.morena.esa.entity.Dish;
import net.morena.esa.sevice.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/dish")
public class DishController {

    private final DishService dishService;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("dishes", dishService.getAll());
        return "dish";
    }

    @GetMapping("/create")
    public String getCreate(@RequestParam int ingCount, Model model) {
        dishService.setParamsForDish(model, ingCount);
        return "dish-create";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute Dish dish, @ModelAttribute IngredientForDishCreationDTO dto) {
        dishService.create(dish, dto);
        return "redirect:/api/v1/dish";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        dishService.deleteById(id);
        return "redirect:/api/v1/dish";
    }

    @GetMapping("/view/{id}")
    public String getOne(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dish", dishService.getById(id));
        return "dish-view";
    }

}