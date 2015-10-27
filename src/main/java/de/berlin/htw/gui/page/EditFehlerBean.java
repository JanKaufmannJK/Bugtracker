package de.berlin.htw.gui.page;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Fehler;
import de.berlin.htw.domain.Status;
import de.berlin.htw.domain.status.Closed;
import de.berlin.htw.domain.status.InProgress;
import de.berlin.htw.domain.status.Reopened;
import de.berlin.htw.domain.status.Resolved;
import de.berlin.htw.domain.status.WaitingForTriage;
import de.berlin.htw.service.BugtrackerService;

@Component
@Scope("singleton")
public class EditFehlerBean {
    
    @Autowired
    private BugtrackerService bs;
    
    @Autowired
    private ProjektBean projektBean;
    

    private Status status = new Status();
    
    private Map<String, Status> statusMap = new HashMap<String, Status>();
    
    @PostConstruct
    public void init() {
        statusMap.put("WaitingForTriage", new WaitingForTriage());
        statusMap.put("Resolved", new Resolved());
        statusMap.put("Reopened", new Reopened());
        statusMap.put("InProgress", new InProgress());
        statusMap.put("Closed", new Closed());
    }
    
    public String showFehler(Fehler fehler) {
        this.setFehler(fehler);
        this.setStatus(statusMap.get(fehler.getStatus()));
        return "/editFehler.xhtml";
    }
    
    public String aendern() {
        bs.mergeObject(fehler);
        fehler = new Fehler();
        return "/showProjekt.xhtml";
    }
    
    public String removeFehler(Fehler fehler) {
        projektBean.getProjekt().getFehlerList().remove(fehler);
        bs.removeObject(fehler);
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
    
    private Fehler fehler = new Fehler();
    
    public Fehler getFehler() {
        return fehler;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
