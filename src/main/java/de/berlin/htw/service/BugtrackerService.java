package de.berlin.htw.service;

import java.util.List;

import de.berlin.htw.domain.Projekt;

public interface BugtrackerService {
	
	public Projekt findByProNr(long proNr);

	public List<Projekt> getProjektListe();
	
	public List<Projekt> selectProjektList();
	
	public void setProjektListe(List<Projekt> projektListe);

	public void persistProjekt(Projekt projekt);
}
