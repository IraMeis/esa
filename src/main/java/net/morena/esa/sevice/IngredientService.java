package net.morena.esa.sevice;


import lombok.RequiredArgsConstructor;
import net.morena.esa.dto.IngredientDTO;
import net.morena.esa.entity.Ingredient;
import net.morena.esa.repository.IngredientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepo ingredientRepo;

    public List<Ingredient> getAll() {
        return ingredientRepo.findAllByIsDeletedFalse();
    }

    public Ingredient getById(Long id) {
        return ingredientRepo.findOneByUniqueIdAndIsDeletedFalse(id);
    }

    public void deleteById(Long id) {
        ingredientRepo.deleteById(id);
    }

    public void create(Ingredient ingredient) {
        ingredientRepo.save(ingredient);
    }

    public void create(IngredientDTO ingredientDTO) {
        Ingredient ingredient = Ingredient
                .builder()
                .name(ingredientDTO.getName())
                .build();
        ingredientRepo.save(ingredient);
    }

}