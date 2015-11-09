package de.berlin.htw.bugtracker.Fehler.Service;

import java.util.List;

import de.berlin.htw.bugtracker.Fehler.Domain.Fehler;
import de.berlin.htw.bugtracker.Fehler.Domain.Projekt;
import de.berlin.htw.bugtracker.Status.Domain.Status;

public interface FehlerService {
    /**
     * 
     * @return
     */
    public List<Projekt> selectProjekteFromDb();
    
    public <T> void persistObject(T entity);
    
    public <T> void mergeObject(T entity);
    
    public <T> void removeObject(T entity);
    
    public void fehlerUpdate(Fehler fehler, Status status);
    
    public Object findFehlerId(long fehler_Id);

}
