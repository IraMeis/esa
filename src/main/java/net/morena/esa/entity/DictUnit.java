package net.morena.esa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import net.morena.esa.entity.base.BaseDict;

@Entity
@Table(name = "dict_unit", schema = "public")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DictUnit extends BaseDict {
}
