package de.berlin.htw.gui.page;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import de.berlin.htw.domain.Fehler;
import de.berlin.htw.domain.Projekt;
import de.berlin.htw.service.BugtrackerService;

@Named("addFehlerBean")
@Scope("request")
public class AddFehlerBean {
	
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

	public String speichern() {
	    fehler.setProjekt(projektBean.getProjekt());
	    fehler.setFeNr((long) (projektBean.getProjekt().getFehlerList().size()+1));
		projektBean.getProjekt().getFehlerList().add(fehler);
		bs.persistFehler(fehler);
		fehler = new Fehler();
		
		return "/showProjekt.xhtml";
	}

	public ProjektBean getProjektBean() {
		return projektBean;
	}

	public void setProjektBean(ProjektBean projektBean) {
		this.projektBean = projektBean;
	}
	
}
