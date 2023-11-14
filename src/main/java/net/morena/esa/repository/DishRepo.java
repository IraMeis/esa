package net.morena.esa.repository;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import net.morena.esa.entity.Dish;

import java.util.List;


@RequiredArgsConstructor
@Stateless
public class DishRepo {

    @PersistenceContext(name = "esa")
    private EntityManager em;

    public void save(Dish o) {
        em.persist(o);
        em.flush();
    }

    public List<Dish> getAll() {
        return em.createQuery(
                "select o from Dish o where o.isDeleted=false",
                        Dish.class)
                .getResultList();
    }

    public Dish getById (Long id) {
        return em.createQuery(
                "select o from Dish o where o.isDeleted=false and o.uniqueId=:id",
                        Dish.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public void deleteById(Long id) {
        em.createQuery("update Dish o set o.isDeleted=true where o.uniqueId=:id",
                        Dish.class)
                .setParameter("id", id)
                .executeUpdate();
    }

}