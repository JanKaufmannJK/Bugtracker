package de.berlin.htw.service;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import de.berlin.htw.domain.Projekt;

@ApplicationScoped
public class BugtrackerService{

	@Inject
	private EntityManager em;
	
	
	public void persistProjekt(Projekt projekt){
		em.persist(projekt);
	}
}
