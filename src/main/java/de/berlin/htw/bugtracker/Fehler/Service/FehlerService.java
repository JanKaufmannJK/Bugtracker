package de.berlin.htw.bugtracker.Fehler.Service;

import java.util.List;

import de.berlin.htw.bugtracker.Fehler.Domain.Fehler;
import de.berlin.htw.bugtracker.Fehler.Domain.Kommentar;
import de.berlin.htw.bugtracker.Fehler.Domain.Projekt;
import de.berlin.htw.bugtracker.Status.Domain.Status;

public interface FehlerService {
	
    /**
     * Methode holt alle Projekte aus der Datenbank und gibt diese in einer Liste zurück.
     * 
     * @return	Liste vom Typ Projekt
     */
    public List<Projekt> selectProjekteFromDb();
    
    /**
     * Generische Methode um die übergebene Entität als Eintrag in der Datenbank zu erzeugen. 
     * 
     * @param entity	generische Entität, welche in die Datenbank persistiert werden soll
     */
    public <T> void persistObject(T entity);
    
    /**
     * Generische Methode um den Eintrag der übergebenen Entität in der Datenbank zu aktualisieren.
     * 
     * @param entity	generische Entität, dessen Eintrag in der Datenbank aktualisiert werden soll
     */
    public <T> void mergeObject(T entity);
    
    /**
     * Generische Methode um den Eintrag der übergebenen Entität aus der Datenbank zu entfernen.
     * 
     * @param entity	generische Entität, dessen Eintrag aus der Datenbank entfernt werden soll
     */
    public <T> void removeObject(T entity);
    
    /**
     * 
     * @param fehler
     * @param verweisFehler
     * @param status
     */
    public void fehlerUpdate(Fehler fehler, Fehler verweisFehler, Status status);
    
    public Object findFehlerId(long fehler_Id);
    
    public List<Kommentar> initFehlerKommentare(Fehler fehler);

}
