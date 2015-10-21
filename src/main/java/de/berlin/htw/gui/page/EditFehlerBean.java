package de.berlin.htw.gui.page;

import java.util.Date;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import de.berlin.htw.domain.Fehler;
import de.berlin.htw.domain.Kommentar;
import de.berlin.htw.domain.Projekt;
import de.berlin.htw.service.BugtrackerService;

@Named("editFehlerBean")
@Scope("request")
public class EditFehlerBean {

	@Autowired
	private BugtrackerService bs;

	@Autowired
	private ProjektBean projektBean;

	@Autowired
	private Fehler fehler;

	public Fehler getFehler() {
		return fehler;
	}

	public void setFehler(Fehler fehler) {
		this.fehler = fehler;
	}

	public String showFehler(Fehler fehler) {
		this.setFehler(fehler);
		return "/editFehler.xhtml";
	}
	
	public String aendern(){
		bs.mergeObject(fehler);
		fehler = new Fehler();
		return "/showProjekt.xhtml";
	}
	
	public String removeFehler(Fehler fehler){
		projektBean.getProjekt().getFehlerList().remove(fehler);
		bs.removeObject(fehler);		
		return "/showProjekt";
	}

	public ProjektBean getProjektBean() {
		return projektBean;
	}

	public void setProjektBean(ProjektBean projektBean) {
		this.projektBean = projektBean;
	}

}
