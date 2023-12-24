package net.morena.esa.sevice;


import lombok.RequiredArgsConstructor;
import net.morena.esa.dto.IngredientDTO;
import net.morena.esa.entity.Ingredient;
import net.morena.esa.jms.Producer;
import net.morena.esa.repository.IngredientRepo;
import net.morena.esa.jms.utils.EventType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepo ingredientRepo;
    private final Producer producer;

    public List<Ingredient> getAll() {
        return ingredientRepo.findAllByIsDeletedFalse();
    }

    public Ingredient getById(Long id) {
        return ingredientRepo.findOneByUniqueIdAndIsDeletedFalse(id);
    }

    public void deleteById(Long id) {
        var entity = ingredientRepo.findOneByUniqueId(id);
        entity.setIsDeleted(true);
        ingredientRepo.save(entity);
        producer.sendMessage(entity, EventType.delete);
    }

    public void create(Ingredient ingredient) {
        ingredientRepo.save(ingredient);
        producer.sendMessage(ingredient, EventType.create);
    }

    public void create(IngredientDTO ingredientDTO) {
        Ingredient ingredient = Ingredient
                .builder()
                .name(ingredientDTO.getName())
                .build();
        ingredientRepo.save(ingredient);
        producer.sendMessage(ingredient, EventType.create);
    }

}