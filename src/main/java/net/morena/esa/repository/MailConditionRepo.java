package net.morena.esa.repository;

import net.morena.esa.entity.MailCondition;
import net.morena.esa.repository.base.BaseEntityRepo;
import org.springframework.stereotype.Repository;


@Repository
public interface MailConditionRepo extends BaseEntityRepo<MailCondition, Long> {
}