package net.morena.esa.entity;

import lombok.*;
import net.morena.esa.entity.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "log_event", schema = "public")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LogEvent extends BaseEntity {

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "description")
    private String description;

}