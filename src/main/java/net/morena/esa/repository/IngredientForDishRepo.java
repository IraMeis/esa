package net.morena.esa.repository;


import net.morena.esa.entity.IngredientForDish;
import net.morena.esa.repository.base.BaseLinkRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientForDishRepo extends BaseLinkRepo<IngredientForDish, Long> {
}