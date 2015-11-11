package de.berlin.htw.bugtracker.Nutzer.Gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import de.berlin.htw.bugtracker.Nutzer.Domain.Nutzer;
import de.berlin.htw.bugtracker.Nutzer.Service.NutzerService;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserBean implements Serializable {
    
    @Autowired
    private NutzerService nutzerService;
    
    private List<Nutzer> nutzerList = new ArrayList<Nutzer>();
    
    private Nutzer nutzer = new Nutzer();
    
    private boolean isUserSet =false;
    
    @PostConstruct
    public void init() {
        nutzerList = nutzerService.selectUsers();
    }
    
    public String save(){
    	isUserSet = true;
    	return "projektList?faces-redirect=true";
    }
    
    public String logout(){
    	isUserSet = false;
    	nutzer = new Nutzer();
    	return "chooseUser?faces-redirect=true";
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

	public boolean getIsUserSet() {
		return isUserSet;
	}
}
