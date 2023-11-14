package net.morena.esa.repository;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import net.morena.esa.entity.Ingredient;

import java.util.List;


@RequiredArgsConstructor
@Stateless
public class IngredientRepo {

    @PersistenceContext(name = "esa")
    private EntityManager em;

    public void save(Ingredient o) {
        em.persist(o);
        em.flush();
    }

    public List<Ingredient> getAll() {
        return em.createQuery(
                "select o from Ingredient o where o.isDeleted=false",
                        Ingredient.class)
                .getResultList();
    }

    public Ingredient getById(Long id) {
        return em.createQuery(
                "select o from Ingredient o where o.isDeleted=false and o.uniqueId=:id",
                        Ingredient.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public void deleteById(Long id) {
        em.createQuery(
                "update Ingredient o set o.isDeleted=true where o.uniqueId=:id",
                        Ingredient.class)
                .setParameter("id", id)
                .executeUpdate();
    }

}