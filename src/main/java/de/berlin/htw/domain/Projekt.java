package de.berlin.htw.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanKa on 12.10.2015.
 */
public class Projekt {

    public Projekt(Long proNr, String bezeichnung) {
        this.proNr = proNr;
        this.bezeichnung = bezeichnung;
    }

    private Long proNr;

    private String bezeichnung;

    private List<Fehler> fehlerList = new ArrayList<Fehler>();


    public Long getProNr() {
        return proNr;
    }

    public void setProNr(Long proNr) {
        this.proNr = proNr;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public List<Fehler> getFehlerList() {
        return fehlerList;
    }

    public void setFehlerList(List<Fehler> fehlerList) {
        this.fehlerList = fehlerList;
    }
}
