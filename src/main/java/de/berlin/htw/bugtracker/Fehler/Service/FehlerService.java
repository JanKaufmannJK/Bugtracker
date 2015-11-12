package de.berlin.htw.bugtracker.Fehler.Service;

import java.util.List;

import de.berlin.htw.bugtracker.Fehler.Domain.Fehler;
import de.berlin.htw.bugtracker.Fehler.Domain.Kommentar;
import de.berlin.htw.bugtracker.Fehler.Domain.Projekt;
import de.berlin.htw.bugtracker.Status.Domain.Status;

public interface FehlerService {

	/**
	 * Methode holt alle Projekte aus der Datenbank und gibt diese in einer
	 * Liste zurück.
	 * 
	 * @return Liste vom Typ Projekt
	 */
	public List<Projekt> selectProjekteFromDb();

	/**
	 * Generische Methode um die übergebene Entität als Eintrag in der Datenbank
	 * zu erzeugen.
	 * 
	 * @param entity
	 *            generische Entität, welche in die Datenbank persistiert werden
	 *            soll
	 */
	public <T> void persistObject(T entity);

	/**
	 * Generische Methode um den Eintrag der übergebenen Entität in der
	 * Datenbank zu aktualisieren.
	 * 
	 * @param entity
	 *            generische Entität, dessen Eintrag in der Datenbank
	 *            aktualisiert werden soll
	 */
	public <T> void mergeObject(T entity);

	/**
	 * Generische Methode um den Eintrag der übergebenen Entität aus der
	 * Datenbank zu entfernen.
	 * 
	 * @param entity
	 *            generische Entität, dessen Eintrag aus der Datenbank entfernt
	 *            werden soll
	 */
	public <T> void removeObject(T entity);

	/**
	 * Methode aktualisiert einen Fehler, indem ein neuer Status gesetzt wird.
	 * Außerdem wird ein weiterer Fehler übergeben auf den verwiesen werden
	 * kann, wenn dieser nicht null ist.
	 * 
	 * @param fehler
	 *            der zu aktualisierende Fehler
	 * @param verweisFehler
	 *            auf den zu verweisenden Fehler
	 * @param status
	 *            neuer Status des Fehlers
	 */
	public void fehlerUpdate(Fehler fehler, Fehler verweisFehler, Status status);

	/**
	 * Die Methode sucht in der Datenbank nach dem passenden Fehler mit Hilfe
	 * der angegbenen Fehler ID und gibt diesen als Object zurück.
	 * 
	 * @param fehler_Id
	 *            Long ID des gesuchten Fehler
	 * @return Object, welches den gesuchten Fehler repräsentiert.
	 */
	public Object findFehlerId(long fehler_Id);

	/**
	 * Die Methode fetcht alle Kommentare eines spezifischen Fehlers und gibt
	 * diese als Liste zurück.
	 * 
	 * @param fehler
	 *            Fehler Object dessen Kommentare gefetcht werden sollen
	 * @return Liste vom Typ Kommentar
	 */
	public List<Kommentar> initFehlerKommentare(Fehler fehler);

	/**
	 * Methode um eine Liste möglichen Fehlern zu erhalten auf die verwiesen
	 * werden kann. Dabei wird sichergestellt, dass in der Liste nur die Fehler
	 * geladen werden, auf die noch nicht verwiesen wurde, nicht den eigenen
	 * Fehler darstellt und aktiv sind.
	 * 
	 * 
	 * @param fehler
	 *            Fehler Object dessen mgöliche Verweisfehler gesucht werden
	 *            soll
	 * @return Liste mit möglichen Verweisfehlern
	 */
	public List<Fehler> getVerweisListe(Fehler fehler);

	/**
	 * Methode um einen bereits verweisten Fehler aus der Liste eines spezifischen Fehlers zu löschen.
	 * 
	 * @param fehler			der Fehler der die VerweisFehler-Liste enthält
	 * @param verweisFehler		der zu löschende Fehler aus der VerweisListe
	 */
	public void removeVerweis(Fehler fehler, Fehler verweisFehler);
}
