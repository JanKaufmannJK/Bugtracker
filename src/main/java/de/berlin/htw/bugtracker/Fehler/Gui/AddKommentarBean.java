package de.berlin.htw.bugtracker.Fehler.Gui;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.bugtracker.Fehler.Domain.Kommentar;
import de.berlin.htw.bugtracker.Fehler.Service.FehlerService;

@Component
@Scope("singleton")
public class AddKommentarBean {

	@Autowired
	private FehlerService fehlerService;

	@Autowired
	private FehlerBean fehlerBean;

	
	private Kommentar kommentar = new Kommentar();

	public void speichern() {
		Date date = new Date();
		kommentar.setNutzer(fehlerBean.getProjektBean().getUserBean().getNutzer());
		kommentar.setErstellt(date);
		kommentar.setFehler(fehlerBean.getFehler());
		fehlerBean.getFehler().getKommentarList().add(kommentar);
		fehlerService.persistObject(kommentar);
		kommentar = new Kommentar();
	}

	public FehlerBean getFehlerBean() {
		return fehlerBean;
	}

	public void setFehlerBean(FehlerBean fehlerBean) {
		this.fehlerBean = fehlerBean;
	}

	public Kommentar getKommentar() {
		return kommentar;
	}

	public void setKommentar(Kommentar kommentar) {
		this.kommentar = kommentar;
	}

}
