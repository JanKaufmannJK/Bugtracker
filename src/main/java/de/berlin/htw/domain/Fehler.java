package de.berlin.htw.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JanKa on 12.10.2015.
 */
public class Fehler {

    private Long feNr;

    private String bezeichnung;

    private String beschreibung;

    private Date erstellt;

    private Status status;

    private Prioritaet prioritaet;

    private List<Kommentar> kommentarList = new ArrayList<Kommentar>();
}
