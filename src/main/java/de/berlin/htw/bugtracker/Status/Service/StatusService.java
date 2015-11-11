package de.berlin.htw.bugtracker.Status.Service;

import java.util.List;

import de.berlin.htw.bugtracker.Status.Domain.Status;

public interface StatusService {
    
    /**
     * Die Methode gibt zu einem Status die, durch den Status-Workflow definierten, passenden Folgestati zurück.
     * Dabei benötigt die Methode die im Status hinterlegte Liste mit den IDs der Folgestati.
     * Die gewünschte Liste wird dann mit Hilfe einer Query aus der Datenbank gelesen.
     * 
     * @param	folgeStatiStaNr		Long Liste mit den IDs der Folgestati
     * @return 						Objektliste vom Typ Status
     */
    public List<Status> selectFolgeStati(List<Long> folgeStatiStaNr);    
    
    /**
     * Die Methode holt sämtliche Status-Varianten aus der Datenbank und gibt eine Liste aus Statusobjekten zurück.
     * 
     * @return Objekteliste vom Typ Status
     */
    public List<Status> selectAllStati();
    
    /**
     * Die Methode sucht in der Datenbank nach dem passenden Status mit Hilfe der angegbenen Status Nummer 
     * und gibt diese als Object zurück.
     * 
     * @param 	staNr	Long ID des gesuchten Status
     * @return			Object, welches den gesuchten Status repräsentiert.
     */
    public Object findByStaNr(long staNr);
    
}
