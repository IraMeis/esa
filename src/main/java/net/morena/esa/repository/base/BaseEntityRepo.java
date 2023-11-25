package net.morena.esa.repository.base;


import net.morena.esa.entity.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface BaseEntityRepo<T extends BaseEntity, ID> extends JpaRepository<T, ID> {

    List<T> findAllByIsDeletedFalse();

    List<T> findAllByIsDeletedTrue();

    T findOneByUniqueIdAndIsDeletedFalse(Long id);

    T findOneByUniqueId(Long id);

    T findOneByUuidAndIsDeletedFalse(UUID uuid);

    T findOneByUuid(UUID uuid);

    @Override
    @Modifying
    @Query(value = "update #{#entityName} f set f.isDeleted=true where f.uniqueId= :id")
    void deleteById(ID id);

    @Override
    @Modifying
    @Query(value = "update #{#entityName} f set f.isDeleted=true where f.uniqueId in :ids")
    void deleteAllById(Iterable<? extends ID> ids);

    @Override
    @Modifying
    @Query(value = "update #{#entityName} f set f.isDeleted=true where f= :entity")
    void delete(@Param("entity") T entity);

    @Override
    @Modifying
    @Query(value = "update #{#entityName} f set f.isDeleted=true where f in :entities")
    void deleteAll(Iterable<? extends T> entities);

}