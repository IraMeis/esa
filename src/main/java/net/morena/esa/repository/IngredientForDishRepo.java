package net.morena.esa.repository;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import net.morena.esa.entity.IngredientForDish;


@RequiredArgsConstructor
@Stateless
public class IngredientForDishRepo {

    @PersistenceContext(name = "esa")
    private EntityManager em;

    public void save(IngredientForDish o) {
        em.persist(o);
    }

}