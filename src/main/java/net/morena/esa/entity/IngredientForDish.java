package net.morena.esa.entity;

import jakarta.persistence.*;
import lombok.*;
import net.morena.esa.entity.base.BaseLink;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "link_dish_ingredient", schema = "public")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IngredientForDish extends BaseLink {

    @OneToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "ingredient_ref", referencedColumnName = "unique_id")
    private Ingredient ingredient;

    @Column(name = "volume")
    private Double volume;

    @OneToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "unit", referencedColumnName = "code")
    private DictUnit unit;

}
