package de.berlin.htw.service;

import java.util.List;

import de.berlin.htw.domain.Fehler;
import de.berlin.htw.domain.Projekt;

public interface BugtrackerService {
	
	public Projekt findByProNr(long proNr);

	public List<Projekt> getProjektListe();
	
	public void setProjektListe(List<Projekt> projektListe);
	
	public List<Projekt> selectProjekteFromDb();

	public void persistProjekt(Projekt projekt);
	
	public void persistFehler(Fehler fehler);
}
