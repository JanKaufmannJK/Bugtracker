package de.berlin.htw.dao;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Dependent
public class EntityManagerProducer {

  @PersistenceContext(unitName = "bugtrackerContext")
  private EntityManager entityManager;

  @Produces
  @RequestScoped
  public EntityManager createEntityManager() {
    return this.entityManager;
  }

  public void dispose(@Disposes EntityManager em) {
    if (em.isOpen()) {
      em.close();
    }
  }
}