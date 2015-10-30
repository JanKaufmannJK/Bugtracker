package de.berlin.htw.gui.page.User;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Nutzer;
import de.berlin.htw.service.NutzerService;

@Component
@Scope("singleton")
public class UserBean {
    
    @Autowired
    private NutzerService nutzerService;
    
    private List<Nutzer> nutzerList = new ArrayList<Nutzer>();
    
    private Nutzer nutzer = new Nutzer();
    
    @PostConstruct
    public void init() {
        nutzerList = nutzerService.selectUsers();
    }
    
    public List<Nutzer> getNutzerList() {
        return nutzerList;
    }
    
    public void setNutzerList(List<Nutzer> nutzerList) {
        this.nutzerList = nutzerList;
    }
    
    public Nutzer getNutzer() {
        return nutzer;
    }
    
    public void setNutzer(Nutzer nutzer) {
        this.nutzer = nutzer;
    }
    
}
