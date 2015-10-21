package de.berlin.htw.gui.page;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import de.berlin.htw.domain.Fehler;
import de.berlin.htw.domain.Projekt;
import de.berlin.htw.service.BugtrackerService;

@Named("fehlerBean")
@Scope("singleton")
public class FehlerBean {
	
	@Autowired
	private BugtrackerService bugtrackerService;
	
	@Autowired
	private Fehler fehler;
	
	@Autowired
	private ProjektBean projektBean;
	
	
	public String showFehler(Fehler fehler){
		this.setFehler(fehler);
		return "/showFehler.xhtml";
	}

	public BugtrackerService getBugtrackerService() {
		return bugtrackerService;
	}

	public void setBugtrackerService(BugtrackerService bugtrackerService) {
		this.bugtrackerService = bugtrackerService;
	}

	public Fehler getFehler() {
		return fehler;
	}

	public void setFehler(Fehler fehler) {
		this.fehler = fehler;
	}

	public ProjektBean getProjektBean() {
		return projektBean;
	}

	public void setProjektBean(ProjektBean projektBean) {
		this.projektBean = projektBean;
	}

}
