package de.berlin.htw.bugtracker.Fehler.Gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.bugtracker.Fehler.Domain.Projekt;
import de.berlin.htw.bugtracker.Fehler.Service.FehlerService;

@Component
@Scope("singleton")
public class AddProjektBean {
	
	@Autowired
	private FehlerService fehlerService;
	
	@Autowired
	private ProjektBean projektBean;
    
	
	private Projekt projekt = new Projekt();

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}

	public String speichern() {
		projektBean.getProjektList().add(projekt);
		fehlerService.persistObject(projekt);
		projekt = new Projekt();
		return "success";
	}

	public ProjektBean getProjektBean() {
		return projektBean;
	}

	public void setProjektBean(ProjektBean projektBean) {
		this.projektBean = projektBean;
	}
	
}
