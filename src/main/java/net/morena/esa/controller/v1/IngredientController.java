package net.morena.esa.controller.v1;


import lombok.RequiredArgsConstructor;
import net.morena.esa.entity.Ingredient;
import net.morena.esa.sevice.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("ingredients", ingredientService.getAll());
        return "ingredient";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredient-create";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute Ingredient ingredient) {
        ingredientService.create(ingredient);
        return "redirect:/api/v1/ingredient";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        ingredientService.deleteById(id);
        return "redirect:/api/v1/ingredient";
    }

}