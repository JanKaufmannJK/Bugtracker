package de.berlin.htw.gui.page;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Fehler;
import de.berlin.htw.service.BugtrackerService;

@Component
@Scope("singleton")
public class AddFehlerBean {

	@Autowired
	private BugtrackerService bs;

	@Autowired
	private ProjektBean projektBean;

	
	private Fehler fehler = new Fehler();

	public Fehler getFehler() {
		return fehler;
	}

	public void setFehler(Fehler fehler) {
		this.fehler = fehler;
	}

	public String speichern() {
		Date date = new Date();
		fehler.setErstellt(date);
		fehler.setProjekt(projektBean.getProjekt());

		if (projektBean.getProjekt().getFehlerList().isEmpty()) {
			fehler.setFeNr(1L);
		} else {
			int lastFeNr = projektBean.getProjekt().getFehlerList().size() - 1;
			fehler.setFeNr(projektBean.getProjekt().getFehlerList().get(lastFeNr).getFeNr() + 1);
		}
		projektBean.getProjekt().getFehlerList().add(fehler);
		bs.persistObject(fehler);
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
