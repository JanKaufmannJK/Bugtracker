package de.berlin.htw.bugtracker.Nutzer.Service;

import java.util.List;

import de.berlin.htw.bugtracker.Nutzer.Domain.Nutzer;

public interface NutzerService {
    
	/**
	 * Die Methode holt alle möglichen User aus der Datenbank und gibt diese in einer Liste zurück.
	 * 
	 * @return	Liste vom Typ Nutzer
	 */
    public List<Nutzer> selectUsers();
    
    
    /**
     * Die Methode sucht in der Datenbank nach dem passenden Nutzer mit Hilfe der angegbenen Nutzer Nummer 
     * und gibt diese als Object zurück.
     * 
     * @param 	nuNr	Long ID des gesuchten Nutzers
     * @return			Object, welches den gesuchten Nutzer repräsentiert.
     */
    public Object findByNuNr(long nuNr);
    
}
