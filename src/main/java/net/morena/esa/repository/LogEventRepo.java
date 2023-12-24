package net.morena.esa.repository;

import net.morena.esa.entity.LogEvent;
import net.morena.esa.repository.base.BaseEntityRepo;
import org.springframework.stereotype.Repository;


@Repository
public interface LogEventRepo extends BaseEntityRepo<LogEvent, Long> {
}