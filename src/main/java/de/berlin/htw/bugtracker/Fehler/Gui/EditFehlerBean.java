package de.berlin.htw.bugtracker.Fehler.Gui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.bugtracker.Fehler.Domain.Fehler;
import de.berlin.htw.bugtracker.Fehler.Service.FehlerService;
import de.berlin.htw.bugtracker.Nutzer.Domain.Nutzer;
import de.berlin.htw.bugtracker.Nutzer.Service.NutzerService;
import de.berlin.htw.bugtracker.Status.Domain.Status;
import de.berlin.htw.bugtracker.Status.Service.StatusService;

@Component
@Scope("singleton")
public class EditFehlerBean {
    
    @Autowired
    private FehlerService fehlerService;
    
    @Autowired
    private StatusService statusService;
    
    @Autowired
    private NutzerService nutzerService;
    
    @Autowired
    private ProjektBean projektBean;
    
    private List<Nutzer> nutzerList = new ArrayList<Nutzer>();
    
    private Fehler fehler = new Fehler();
    
    private Fehler verweisFehler = new Fehler();
    
    private Status status = new Status();
    
    private List<Status> folgeStati = null;
    
    private List<Fehler> filteredFehler;
    
    @PostConstruct
    public void init() {
        nutzerList = nutzerService.selectUsers();
    }
    
    public String showFehler(Fehler f) {
        
        this.setFehler(f);
        folgeStati = statusService.selectFolgeStati(f.getStatus().getStatusInfo());
        return "/editFehler.xhtml";
    }
    
    public String aendern() {        
        fehlerService.fehlerUpdate(fehler, status);
        return "showProjekt?faces-redirect=true";
    }
    
    public void toggleFehler(Fehler f) {
        f.setAktiv(!f.getAktiv());
        fehlerService.mergeObject(f);
    }
    
    public ProjektBean getProjektBean() {
        return projektBean;
    }
    
    public void setProjektBean(ProjektBean projektBean) {
        this.projektBean = projektBean;
    }
    
    public void setFehler(Fehler fehler) {
        this.fehler = fehler;
    }
    
    public Fehler getFehler() {
        return fehler;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public List<Status> getFolgeStati() {
        return folgeStati;
    }
    
    public void setFolgeStati(List<Status> folgeStati) {
        this.folgeStati = folgeStati;
    }
    
    public NutzerService getNutzerService() {
        return nutzerService;
    }
    
    public void setNutzerService(NutzerService nutzerService) {
        this.nutzerService = nutzerService;
    }
    
    public List<Nutzer> getNutzerList() {
        return nutzerList;
    }
    
    public void setNutzerList(List<Nutzer> nutzerList) {
        this.nutzerList = nutzerList;
    }
    
    public List<Fehler> getFilteredFehler() {
        return filteredFehler;
    }
    
    public void setFilteredFehler(List<Fehler> filteredFehler) {
        this.filteredFehler = filteredFehler;
    }

	public Fehler getVerweisFehler() {
		return verweisFehler;
	}

	public void setVerweisFehler(Fehler verweisFehler) {
		this.verweisFehler = verweisFehler;
	}
    
}
