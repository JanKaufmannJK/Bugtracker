package de.berlin.htw.bugtracker.Fehler.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.berlin.htw.bugtracker.Fehler.Domain.Fehler;
import de.berlin.htw.bugtracker.Fehler.Domain.Projekt;
import de.berlin.htw.bugtracker.Status.Domain.Status;

@Service
@Scope("singleton")
public class FehlerServiceImpl implements FehlerService {

	@PersistenceContext
	private EntityManager em;

	private List<Projekt> projektListe = new ArrayList<Projekt>();

	public EntityManager getEm() {
		return em;
	}

	@Transactional
	public void fehlerUpdate(Fehler fehler, Status status) {
		fehler.setStatus(status);
		mergeObject(fehler);
	}

	@Transactional
	public <T> void persistObject(T entity) {
		em.persist(entity);
	}

	@Transactional
	public <T> void removeObject(T entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Transactional
	public <T> void mergeObject(T entity) {
		em.merge(entity);
	}

	@Transactional
	public List<Projekt> selectProjekteFromDb() {
		TypedQuery<Projekt> query = em.createQuery("SELECT c FROM Projekt c", Projekt.class);
		projektListe = query.getResultList();
		return projektListe;
	}

	@Transactional
	public Object findFehlerId(long fehler_Id) {
		TypedQuery<Fehler> query = em.createQuery("SELECT c FROM Fehler c WHERE c.fehler_Id = :fehler_Id ",
				Fehler.class);
		query.setParameter("fehler_Id", fehler_Id);
		return query.getSingleResult();
	}

	public void setProjektListe(List<Projekt> projektListe) {
		this.projektListe = projektListe;
	}

	public List<Projekt> getProjektListe() {
		return projektListe;
	}

}
