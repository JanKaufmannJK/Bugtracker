package de.berlin.htw.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.berlin.htw.domain.Nutzer;

@Service
@Scope("singleton")
public class NutzerServiceImpl implements NutzerService {
    
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public List<Nutzer> selectUsers() {
        TypedQuery<Nutzer> query = em.createQuery("SELECT nutzer FROM Nutzer nutzer", Nutzer.class);
        return query.getResultList();
    }
    
    @Transactional
    public Object findByNuNr(long nuNr){
        TypedQuery<Nutzer> query = em.createQuery("SELECT nutzer FROM Nutzer nutzer WHERE nutzer.nuNr = :nuNr ", Nutzer.class);
        query.setParameter("nuNr", nuNr);
        return query.getSingleResult();
    }
    
}
