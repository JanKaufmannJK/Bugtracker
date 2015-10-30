package de.berlin.htw.gui.page.Projekt;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Fehler;
import de.berlin.htw.domain.Status;
import de.berlin.htw.service.FehlerService;
import de.berlin.htw.service.StatusService;

@Component
@Scope("singleton")
public class AddFehlerBean {

	@PostConstruct
	public void init() {
		try {
			prop.load(AddFehlerBean.class.getClassLoader().getResourceAsStream("bugtracker.properties"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		creationStatus = prop.getProperty("addFehlerBean.creationStatus");
		System.out.println(prop.getProperty("addFehlerBean.creationStatus"));
	}

	@Autowired
	private Properties prop;

	@Autowired
	private FehlerService fehlerService;

	@Autowired
	private StatusService statusService;

	@Autowired
	private ProjektBean projektBean;

	private Fehler fehler = new Fehler();

	private String creationStatus;

	public Fehler getFehler() {
		return fehler;
	}

	public void setFehler(Fehler fehler) {
		this.fehler = fehler;
	}

	public String speichern() {

		Status status = null;
		for (Status s : statusService.selectAllStati()) {
			if (s.getBezeichnung().equals(creationStatus)) {
				status = s;
			}
		}

		fehler.setStatus(status);
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
		fehlerService.persistObject(fehler);
		fehler = new Fehler();

		return "/showProjekt.xhtml";
	}

	public ProjektBean getProjektBean() {
		return projektBean;
	}

	public void setProjektBean(ProjektBean projektBean) {
		this.projektBean = projektBean;
	}

	public String getCreationStatus() {
		return creationStatus;
	}

	public void setCreationStatus(String creationStatus) {
		this.creationStatus = creationStatus;
	}

}
