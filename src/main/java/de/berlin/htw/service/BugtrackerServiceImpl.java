package de.berlin.htw.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.berlin.htw.domain.Fehler;
import de.berlin.htw.domain.Projekt;

@Service
@Scope("singleton")
public class BugtrackerServiceImpl implements BugtrackerService {
    
    @PersistenceContext
    private EntityManager em;
    
    private List<Projekt> projektListe = new ArrayList<Projekt>();
    
    public EntityManager getEm() {
        return em;
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
    public void persistFehler(Fehler fehler) {
        em.persist(fehler);
    }
    
    @Transactional
    public List<Projekt> selectProjekteFromDb() {
        TypedQuery<Projekt> query = em.createQuery("SELECT c FROM Projekt c", Projekt.class);
        projektListe = query.getResultList();
        return projektListe;
    }
    
    public void setProjektListe(List<Projekt> projektListe) {
        this.projektListe = projektListe;
    }
    
    public List<Projekt> getProjektListe() {
        return projektListe;
    }
    
}
