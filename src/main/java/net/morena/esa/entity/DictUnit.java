package net.morena.esa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.*;
import net.morena.esa.entity.base.BaseEntity;

@Entity
@Table(name = "dict_unit", schema = "public")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DictUnit extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private Long code;

    @Column(name = "description")
    private String description;
}
