package de.berlin.htw.gui.page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Fehler;
import de.berlin.htw.domain.Status;
import de.berlin.htw.service.BugtrackerService;

@Component
@Scope("singleton")
public class EditFehlerBean {

	@Autowired
	private BugtrackerService bs;

	@Autowired
	private ProjektBean projektBean;

	private Fehler fehler = new Fehler();

	private Status status = new Status();

	private List<Status> folgeStati = null;

	public String showFehler(Fehler fehler) {

		this.setFehler(fehler);
		folgeStati = new ArrayList<Status>();

		for (Status s : projektBean.getStatusList()) {
			for (int i : fehler.getStatus().getStatusInfo()) {
				if (s.getStaNr() == i) {
					folgeStati.add(s);
				}
			}
		}
	
		return "/editFehler.xhtml";
	}

	public String aendern() {
		bs.mergeObject(fehler);
		fehler = new Fehler();
		return "/showProjekt.xhtml";
	}

	public String removeFehler(Fehler fehler) {
		projektBean.getProjekt().getFehlerList().remove(fehler);
		bs.removeObject(fehler);
		return "/showProjekt.xhtml";
	}

	public ProjektBean getProjektBean() {
		return projektBean;
	}

	public void setProjektBean(ProjektBean projektBean) {
		this.projektBean = projektBean;
	}

	public void setFehler(Fehler fehler) {
		this.fehler = fehler;
	}

	public Fehler getFehler() {
		return fehler;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Status> getFolgeStati() {
		return folgeStati;
	}

	public void setFolgeStati(List<Status> folgeStati) {
		this.folgeStati = folgeStati;
	}

}
