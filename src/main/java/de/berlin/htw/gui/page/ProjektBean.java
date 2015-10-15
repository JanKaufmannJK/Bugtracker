package de.berlin.htw.gui.page;

import de.berlin.htw.domain.Projekt;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanKa on 12.10.2015.
 */

@ManagedBean
@SessionScoped
public class ProjektBean {

    private Projekt projekt = new Projekt();

    private List<Projekt> projektList = new ArrayList<Projekt>();

    public List<Projekt> getProjektList() {

        return projektList;

    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }

    public String speichern() {
        projektList.add(projekt);
        return "/projektList.xhtml";
    }
}
