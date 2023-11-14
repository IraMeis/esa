package net.morena.esa.repository;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import net.morena.esa.entity.DictUnit;

import java.util.List;


@RequiredArgsConstructor
@Stateless
public class DictUnitRepo {

    @PersistenceContext(name = "esa")
    private EntityManager em;

    public List<DictUnit> getAll() {
        return em.createQuery(
                "select o from DictUnit o where o.isDeleted=false",
                        DictUnit.class)
                .getResultList();
    }

    public DictUnit getByCode (Long id) {
        return em.createQuery(
                "select o from DictUnit o where o.isDeleted=false and o.code=:id",
                        DictUnit.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}