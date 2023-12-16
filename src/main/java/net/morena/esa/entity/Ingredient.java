package net.morena.esa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
