package de.berlin.htw.gui.page;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import de.berlin.htw.domain.Projekt;

/**
 * Created by JanKa on 12.10.2015.
 */

@ManagedBean(name="projektBean")
@ApplicationScoped
public class ProjektBean {

	private List<Projekt> projektList = new ArrayList<Projekt>();

	public List<Projekt> getProjektList() {
		return projektList;
	}
}
