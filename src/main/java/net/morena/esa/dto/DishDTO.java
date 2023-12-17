package net.morena.esa.dto;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.morena.esa.entity.Dish;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class DishDTO {

    private String name;
    private Double portion;
    private String recipe;
    private String timeMin;
    private String timeMax;
    private List<SimpleIngredientDTO> ingredients;

    private long uniqueId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private String createdTimestamp;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private String modifiedTimestamp;

    public static DishDTO toDTO(Dish obj){

        var ingredients = obj.getIngredientForDish()
                .stream()
                .map(ing -> SimpleIngredientDTO.builder()
                        .ingredientId(ing.getIngredient().getUniqueId())
                        .ingredientName(ing.getIngredient().getName())
                        .unitCode(ing.getUnit() == null ? 0 : ing.getUnit().getCode())
                        .unitName(ing.getUnit() == null ? "" : ing.getUnit().getName())
                        .volume(ing.getVolume() == null ? 0. : ing.getVolume())
                        .build())
                .collect(Collectors.toList());

        return DishDTO.builder()
                .uniqueId(obj.getUniqueId())
                .modifiedTimestamp(obj.getModifiedTimestamp().toString())
                .createdTimestamp(obj.getCreatedTimestamp().toString())
                .name(obj.getName())
                .recipe(obj.getRecipe())
                .portion(obj.getPortion())
                .timeMax(obj.getTimeMax())
                .timeMin(obj.getTimeMin())
                .ingredients(ingredients)
                .build();
    }
}
