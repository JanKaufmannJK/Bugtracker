package de.berlin.htw.bugtracker.Status.Service;

import java.util.List;

import de.berlin.htw.bugtracker.Status.Domain.Status;

public interface StatusService { 
    
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
