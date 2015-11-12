package de.berlin.htw.bugtracker.Fehler.Gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.bugtracker.Fehler.Domain.Fehler;
import de.berlin.htw.bugtracker.Fehler.Service.FehlerService;

@Component
@Scope("singleton")
public class FehlerBean {

	@Autowired
	private FehlerService fehlerService;

	private Fehler fehler = new Fehler();

	@Autowired
	private ProjektBean projektBean;

	public String showFehler(Fehler fehler) {
		fehler.setKommentarList(fehlerService.initFehlerKommentare(fehler));
		this.setFehler(fehler);
		return "success";
	}

	public void removeVerweis(Fehler verweisFehler) {
		fehlerService.removeVerweis(fehler, verweisFehler);
	}

	public FehlerService getBugtrackerService() {
		return fehlerService;
	}

	public void setBugtrackerService(FehlerService bugtrackerService) {
		this.fehlerService = bugtrackerService;
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
