package de.berlin.htw.gui.page.Fehler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Fehler;
import de.berlin.htw.domain.Status;
import de.berlin.htw.gui.page.Projekt.ProjektBean;
import de.berlin.htw.service.FehlerService;
import de.berlin.htw.service.StatusService;

@Component
@Scope("singleton")
public class EditFehlerBean {
    
    @Autowired
    private FehlerService fehlerService;
    
    @Autowired
    private StatusService statusService;
    
    @Autowired
    private ProjektBean projektBean;
    
    private Fehler fehler = new Fehler();
    
    private Status status = new Status();
    
    private List<Status> folgeStati = null;
    
    public String showFehler(Fehler fehler) {
        
        this.setFehler(fehler);
        folgeStati = statusService.selectFolgeStati(fehler.getStatus().getStatusInfo());
        return "/editFehler.xhtml";
    }
    
    public String aendern() {
        fehler.setStatus(status);
        fehlerService.mergeObject(fehler);
        return "/showProjekt.xhtml";
    }
    
    public String removeFehler(Fehler fehler) {
        projektBean.getProjekt().getFehlerList().remove(fehler);
        fehlerService.removeObject(fehler);
        return "/showProjekt.xhtml";
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
    
}
