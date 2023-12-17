package net.morena.esa.dto;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.morena.esa.entity.Ingredient;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class IngredientDTO {

    private String name;

    private long uniqueId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private String createdTimestamp;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private String modifiedTimestamp;

    public static IngredientDTO toDTO(Ingredient obj){
        return IngredientDTO.builder()
                .uniqueId(obj.getUniqueId())
                .modifiedTimestamp(obj.getModifiedTimestamp().toString())
                .createdTimestamp(obj.getCreatedTimestamp().toString())
                .name(obj.getName())
                .build();
    }
}
