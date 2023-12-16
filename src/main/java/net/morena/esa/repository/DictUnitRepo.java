package net.morena.esa.repository;


import net.morena.esa.entity.DictUnit;
import net.morena.esa.repository.base.BaseEntityRepo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DictUnitRepo extends BaseEntityRepo<DictUnit, Long> {

    DictUnit getByCodeAndIsDeletedFalse(Long code);

}