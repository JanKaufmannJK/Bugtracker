package de.berlin.htw.service;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.berlin.htw.domain.Projekt;

@ApplicationScoped
public class BugtrackerServiceImpl implements BugtrackerService{
	
	
	private EntityManager em = JPAUtil.getEm();

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void persistProjekt(Projekt projekt){
		
		em.getTransaction().begin();
		em.persist(projekt);
		em.getTransaction().commit();
	}
}
