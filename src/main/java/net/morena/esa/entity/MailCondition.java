package net.morena.esa.entity;

import lombok.*;
import net.morena.esa.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mail_condition", schema = "public")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MailCondition extends BaseEntity {

    @Column(name = "address")
    private String address;

    @Column(name = "condition")
    private String condition;

}