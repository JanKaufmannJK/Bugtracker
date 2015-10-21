package de.berlin.htw.gui.page;

import java.util.Date;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import de.berlin.htw.domain.Kommentar;
import de.berlin.htw.service.BugtrackerService;

@Named("addKommentarBean")
@Scope("request")
public class AddKommentarBean {

	@Autowired
	private BugtrackerService bs;

	@Autowired
	private FehlerBean fehlerBean;

	@Autowired
	private Kommentar kommentar;

	public String speichern() {
		Date date = new Date();
		kommentar.setErstellt(date);
		kommentar.setFehler(fehlerBean.getFehler());
		if (fehlerBean.getFehler().getKommentarList().isEmpty()) {
			kommentar.setKoNr(1L);
		} else {
			int lastKoNr = fehlerBean.getFehler().getKommentarList().size() - 1;
			kommentar.setKoNr((long) (fehlerBean.getFehler().getKommentarList().get(lastKoNr).getKoNr() + 1));
		}
		fehlerBean.getFehler().getKommentarList().add(kommentar);
		bs.persistObject(kommentar);
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
