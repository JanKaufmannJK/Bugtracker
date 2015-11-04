package de.berlin.htw.gui.page.Kommentar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Kommentar;
import de.berlin.htw.gui.page.Fehler.FehlerBean;
import de.berlin.htw.service.FehlerService;

@Component
@Scope("singleton")
public class EditKommentarBean {

	@Autowired
	private FehlerService fehlerService;

	@Autowired
	private FehlerBean fehlerBean;

	
	private Kommentar kommentar = new Kommentar();

	public String showKommentar(Kommentar kommentar) {		
		this.setKommentar(kommentar);
		return "editKommentar?faces-redirect=true";
	}
	
	public void removeKommentar(Kommentar kommentar){
		fehlerBean.getFehler().getKommentarList().remove(kommentar);
		fehlerService.removeObject(kommentar);		
	}
	
	public String aendern(){
	    fehlerService.mergeObject(kommentar);
		kommentar = new Kommentar();
		return "showFehler?faces-redirect=true";
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
