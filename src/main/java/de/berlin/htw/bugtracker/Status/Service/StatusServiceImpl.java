package de.berlin.htw.bugtracker.Status.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.berlin.htw.bugtracker.Status.Domain.Status;


@Service
@Scope("singleton")
public class StatusServiceImpl implements StatusService{
    
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public List<Status> selectFolgeStati(List<Long> folgeStatiStaNr){
        
        TypedQuery<Status> query = em.createQuery("SELECT status FROM Status status WHERE status.staNr IN (:folgeStatiStaNr)", Status.class);
        query.setParameter("folgeStatiStaNr", folgeStatiStaNr);        
        return query.getResultList();        
    }
    
    @Transactional
    public Object findByStaNr(long staNr){
        TypedQuery<Status> query = em.createQuery("SELECT c FROM Status c WHERE c.staNr = :staNr ", Status.class);
        query.setParameter("staNr", staNr);
        return query.getSingleResult();
    }
    
    @Transactional
    public List<Status> selectAllStati(){
        TypedQuery<Status> query = em.createQuery("SELECT c FROM Status c", Status.class);
        List<Status> statusList = query.getResultList();
        return statusList;
    }
    
}
