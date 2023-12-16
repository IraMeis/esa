package net.morena.esa.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class SimpleIngredientDTO {

    private long unitCode;
    private long ingredientId;
    private double volume;

}
