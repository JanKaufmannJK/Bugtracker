package de.berlin.htw.gui.page;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Projekt;
import de.berlin.htw.service.BugtrackerService;

/**
 * Created by JanKa on 12.10.2015.
 */

@Component
@Scope("singleton")
public class ProjektBean {
    
    @Autowired
    private BugtrackerService bugtrackerService;
    
    
    private Projekt projekt = new Projekt();
    
    private List<Projekt> projektList;
    
    @PostConstruct
    private void init(){
        projektList = bugtrackerService.selectProjekteFromDb();
    }
    
    public List<Projekt> getProjektList() {
        return projektList;
    }
    
    public String showProjekt(Projekt projekt) {
        this.setProjekt(projekt);
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
