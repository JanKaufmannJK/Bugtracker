package de.berlin.htw.gui.page;

import de.berlin.htw.domain.Projekt;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by JanKa on 12.10.2015.
 */

@ManagedBean
@SessionScoped
public class ProjektBean {

    //Testdaten
    private static final Projekt[] projektList = new Projekt[] {
            new Projekt(1L, "Projekt 1"),
            new Projekt(1L, "Projekt 2"),
            new Projekt(1L, "Projekt 3"),
            new Projekt(1L, "Projekt 4"),
            new Projekt(1L, "Projekt 5")
    };

    public Projekt[] getProjektList() {

        return projektList;

    }


}
