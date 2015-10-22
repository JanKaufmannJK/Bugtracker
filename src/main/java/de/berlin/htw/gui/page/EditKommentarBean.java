package de.berlin.htw.gui.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Kommentar;
import de.berlin.htw.service.BugtrackerService;

@Component
@Scope("singleton")
public class EditKommentarBean {

	@Autowired
	private BugtrackerService bs;

	@Autowired
	private FehlerBean fehlerBean;

	
	private Kommentar kommentar = new Kommentar();

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
