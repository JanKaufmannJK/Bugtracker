package de.berlin.htw.gui.page;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import de.berlin.htw.domain.Projekt;
import de.berlin.htw.service.BugtrackerService;

@Named("addProjektBean")
@Scope("request")
public class AddProjektBean {
	
    @Autowired
	private BugtrackerService bs;
	
    @Autowired
	private ProjektBean projektBean;
    
    @Autowired
	private Projekt projekt;

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}

	public String speichern() {
		projektBean.getProjektList().add(projekt);
		bs.persistProjekt(projekt);
		projekt = new Projekt();
		return "/projektList.xhtml";
	}

	public ProjektBean getProjektBean() {
		return projektBean;
	}

	public void setProjektBean(ProjektBean projektBean) {
		this.projektBean = projektBean;
	}
	
}
