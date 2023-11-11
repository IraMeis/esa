package net.morena.esa.entity;

import jakarta.persistence.*;
import lombok.*;
import net.morena.esa.entity.base.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.util.Set;

@Entity
@Table(name = "dish", schema = "public")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Dish extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "portion")
    private Double portion;

    @Column(name = "recipe")
    private String recipe;

    @Column(name = "time_min")
    private String time_min;

    @Column(name = "time_max")
    private String time_max;

    @OneToMany
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "dish_ref")
    private Set<IngredientForDish> ingredientForDish;

}