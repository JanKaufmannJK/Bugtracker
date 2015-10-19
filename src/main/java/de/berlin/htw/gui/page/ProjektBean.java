package de.berlin.htw.gui.page;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import de.berlin.htw.domain.Projekt;
import de.berlin.htw.service.BugtrackerService;
import de.berlin.htw.service.BugtrackerServiceImpl;

/**
 * Created by JanKa on 12.10.2015.
 */

@ManagedBean(name="projektBean")
@ApplicationScoped
public class ProjektBean {
	
	private BugtrackerService bs =  new BugtrackerServiceImpl();
	
	private Projekt projekt = new Projekt();

	private List<Projekt> projektList = bs.selectProjektList();

	public List<Projekt> getProjektList() {
		return projektList;
	}
	
	 public String showProjekt(long proNr) {
		 	bs.setProjektListe(projektList);
	        this.setProjekt(bs.findByProNr(proNr));
	        return "/showProjekt.xhtml";
	    }

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}
}
