package de.berlin.htw.service;

import java.util.List;

import de.berlin.htw.domain.Projekt;
import de.berlin.htw.domain.Status;

public interface BugtrackerService {
    
    public List<Projekt> selectProjekteFromDb();
    
    public <T> void persistObject(T entity);
    
    public <T> void mergeObject(T entity);
    
    public <T> void removeObject(T entity);
    
    public Status selectStatus(String bez);
    
    public List<Status> selectAllStati();
}
