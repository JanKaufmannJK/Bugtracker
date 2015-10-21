package de.berlin.htw.gui.page;

import java.util.Date;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import de.berlin.htw.domain.Kommentar;
import de.berlin.htw.domain.Projekt;
import de.berlin.htw.service.BugtrackerService;

@Named("editKommentarBean")
@Scope("request")
public class EditKommentarBean {

	@Autowired
	private BugtrackerService bs;

	@Autowired
	private FehlerBean fehlerBean;

	@Autowired
	private Kommentar kommentar;

	public String showKommentar(Kommentar kommentar) {		
		this.setKommentar(kommentar);
		return "/editKommentar.xhtml";
	}
	
	public String removeKommentar(Kommentar kommentar){
		fehlerBean.getFehler().getKommentarList().remove(kommentar);
		bs.removeObject(kommentar);		
		return "/showFehler";
	}
	
	public String aendern(){
		bs.mergeObject(kommentar);
		kommentar = new Kommentar();
		return "/showFehler.xhtml";
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
