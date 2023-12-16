package net.morena.esa.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class IngredientForDishCreationDTO {

    private List<SimpleIngredientDTO> ingredients = new ArrayList<>();

    public void addSimpleIngredient(SimpleIngredientDTO dto) {
        this.ingredients.add(dto);
    }

}
