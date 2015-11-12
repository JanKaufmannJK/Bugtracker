package de.berlin.htw.bugtracker.Fehler.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.berlin.htw.bugtracker.Fehler.Domain.Fehler;
import de.berlin.htw.bugtracker.Fehler.Domain.Kommentar;
import de.berlin.htw.bugtracker.Fehler.Domain.Projekt;
import de.berlin.htw.bugtracker.Status.Domain.Status;

@Service
@Scope("singleton")
@Transactional
public class FehlerServiceImpl implements FehlerService {

	@PersistenceContext
	private EntityManager em;

	private List<Projekt> projektListe = new ArrayList<Projekt>();

	public EntityManager getEm() {
		return em;
	}

	public List<Fehler> getVerweisListe(Fehler fehler) {
		TypedQuery<Fehler> query;
		if (fehler.getFehlerVerweise().isEmpty()) {
			query = em.createQuery("SELECT f FROM Fehler f WHERE f != :fehler AND f.aktiv = true", Fehler.class);

		} else {
			query = em.createQuery("SELECT f FROM Fehler f WHERE f != :fehler AND f NOT IN :verweisliste AND f.aktiv = true",
					Fehler.class);
			query.setParameter("verweisliste", fehler.getFehlerVerweise());
		}
		query.setParameter("fehler", fehler);
		return query.getResultList();
	}

	public List<Kommentar> initFehlerKommentare(Fehler fehler) {
		TypedQuery<Kommentar> query = em
				.createQuery("SELECT k FROM Kommentar k INNER JOIN k.fehler WHERE k.fehler = :fehler", Kommentar.class);
		query.setParameter("fehler", fehler);
		return query.getResultList();
	}
	
	public void removeVerweis(Fehler fehler, Fehler verweisFehler){
		fehler.getFehlerVerweise().remove(verweisFehler);
		mergeObject(fehler);
	}

	public void fehlerUpdate(Fehler fehler, Fehler verweisFehler, Status status) {
		if (verweisFehler != null) {
			fehler.getFehlerVerweise().add(verweisFehler);
		}
		fehler.setStatus(status);
		mergeObject(fehler);
	}

	public <T> void persistObject(T entity) {
		em.persist(entity);
	}

	public <T> void removeObject(T entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public <T> void mergeObject(T entity) {
		em.merge(entity);
	}

	public List<Projekt> selectProjekteFromDb() {
		TypedQuery<Projekt> query = em.createQuery("SELECT c FROM Projekt c", Projekt.class);
		projektListe = query.getResultList();
		return projektListe;
	}

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
