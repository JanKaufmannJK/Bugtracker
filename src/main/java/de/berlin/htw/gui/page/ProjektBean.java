package de.berlin.htw.gui.page;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import de.berlin.htw.domain.Projekt;
import de.berlin.htw.service.BugtrackerService;
import de.berlin.htw.service.BugtrackerServiceImpl;

/**
 * Created by JanKa on 12.10.2015.
 */

@Named("projektBean")
@Scope("singleton")
public class ProjektBean {
    
    @Autowired
    private BugtrackerService bugtrackerService;
    
    private Projekt projekt = new Projekt();
    
    private List<Projekt> projektList = new ArrayList<Projekt>();
    
    @PostConstruct
    private void init(){
        projektList = bugtrackerService.selectProjekteFromDb();
    }
    
    public List<Projekt> getProjektList() {
        return projektList;
    }
    
    public String showProjekt(long proNr) {
        this.setProjekt(bugtrackerService.findByProNr(proNr));
        return "/showProjekt.xhtml";
    }
    
    public Projekt getProjekt() {
        return projekt;
    }
    
    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }

    public BugtrackerService getBugtrackerService() {
        return bugtrackerService;
    }

    public void setBugtrackerService(BugtrackerService bugtrackerService) {
        this.bugtrackerService = bugtrackerService;
    }
}
