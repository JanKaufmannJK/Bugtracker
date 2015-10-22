package de.berlin.htw.gui.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Projekt;
import de.berlin.htw.service.BugtrackerService;

@Component
@Scope("singleton")
public class AddProjektBean {
	
	@Autowired
	private BugtrackerService bs;
	
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
		bs.persistObject(projekt);
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
