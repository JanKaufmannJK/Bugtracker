package de.berlin.htw.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import de.berlin.htw.domain.Projekt;

@ApplicationScoped
public class BugtrackerServiceImpl implements BugtrackerService {
	
	List<Projekt> projektListe = new ArrayList<Projekt>();
	
    @PostConstruct
    private void initialize() {
    	projektListe = selectProjektList();
    }

	private EntityManager em = JPAUtil.getEm();

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void persistProjekt(Projekt projekt) {

		em.getTransaction().begin();
		em.persist(projekt);
		em.getTransaction().commit();
	}

	@Transactional
	public List<Projekt> selectProjektList() {

		TypedQuery<Projekt> query = em.createQuery("SELECT c FROM Projekt c", Projekt.class);
		List<Projekt> results = query.getResultList();

		return results;
	}
	
	public Projekt findByProNr(long proNr){
		for (Projekt p : projektListe) {
            if (p.getProNr() == proNr) {
                return p;
            }
        }
        return null;
	}

	public List<Projekt> getProjektListe() {
		return projektListe;
	}

	public void setProjektListe(List<Projekt> projektListe) {
		this.projektListe = projektListe;
	}
}
