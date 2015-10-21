package de.berlin.htw.service;

import java.util.List;

import de.berlin.htw.domain.Fehler;
import de.berlin.htw.domain.Projekt;

public interface BugtrackerService {

	public List<Projekt> getProjektListe();
	
	public void setProjektListe(List<Projekt> projektListe);
	
	public List<Projekt> selectProjekteFromDb();

	public <T> void persistObject(T entity);
	
	 public <T> void mergeObject(T entity);
	 
	 public <T> void removeObject(T entity);
}
