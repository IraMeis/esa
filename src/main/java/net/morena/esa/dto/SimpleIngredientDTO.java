package net.morena.esa.dto;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SimpleIngredientDTO {

    private long unitCode;
    private String unitName;
    private long ingredientId;
    private String ingredientName;
    private double volume;

}
