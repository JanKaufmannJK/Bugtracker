package de.berlin.htw.gui.page;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import de.berlin.htw.domain.Projekt;
import de.berlin.htw.service.BugtrackerService;

@RequestScoped
@ManagedBean
public class AddProjectBean {
	
	@ManagedProperty(value="#{projektBean}")
	private ProjektBean projektBean;

	@Inject
	private BugtrackerService bs;
	
	private Projekt projekt = new Projekt();

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}

	public String speichern() {
		projektBean.getProjektList().add(projekt);
		bs.persistProjekt(projekt);
		return "/projektList.xhtml";
	}

	public ProjektBean getProjektBean() {
		return projektBean;
	}

	public void setProjektBean(ProjektBean projektBean) {
		this.projektBean = projektBean;
	}
	
}
