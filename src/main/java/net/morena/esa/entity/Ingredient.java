package net.morena.esa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import net.morena.esa.entity.base.BaseEntity;

@Entity
@Table(name = "ingredient", schema = "public")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Ingredient extends BaseEntity {

    @Column(name = "name")
    private String name;

}
