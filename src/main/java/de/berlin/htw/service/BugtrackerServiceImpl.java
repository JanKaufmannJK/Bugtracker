package de.berlin.htw.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Transactional;

import de.berlin.htw.domain.Projekt;

@Named("bugtrackerService")
@Scope("singleton")
public class BugtrackerServiceImpl implements BugtrackerService {
    
    @PersistenceContext
    private EntityManager em;
    
    private List<Projekt> projektListe = new ArrayList<Projekt>();
    
    public EntityManager getEm() {
        return em;
    }
    
    @Transactional
    public void persistProjekt(Projekt projekt) {
        em.persist(projekt);
    }
    
    @Transactional
    public List<Projekt> selectProjekteFromDb() {
        TypedQuery<Projekt> query = em.createQuery("SELECT c FROM Projekt c", Projekt.class);
        projektListe = query.getResultList();
        return projektListe;
    }
    
    public Projekt findByProNr(long proNr) {
        for (Projekt p : projektListe) {
            if (p.getProNr() == proNr) {
                return p;
            }
        }
        return null;
    }
    
    public void setProjektListe(List<Projekt> projektListe) {
        this.projektListe = projektListe;
    }
    
    public List<Projekt> getProjektListe() {
        return projektListe;
    }
    
}
