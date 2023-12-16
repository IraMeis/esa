package net.morena.esa.repository;


import net.morena.esa.entity.Ingredient;
import net.morena.esa.repository.base.BaseEntityRepo;
import org.springframework.stereotype.Repository;


@Repository
public interface IngredientRepo extends BaseEntityRepo<Ingredient, Long>  {
}