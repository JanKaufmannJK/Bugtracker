package de.berlin.htw.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by JanKa on 12.10.2015.
 */
@Entity
@Table(name = "FEHLER")
public class Fehler {

	@Id
	@Column(name ="FENR")
    private Long feNr;

	@Column(name ="BEZEICHNUNG")
    private String bezeichnung;

	@Column(name ="BESCHREIBUNG")
    private String beschreibung;

	@Column(name ="ERSTELLT")
    private Date erstellt;

	@Column(name ="STATUS")
    private Status status;

	@Column(name ="PRIO")
    private Prioritaet prioritaet;
	
    @ManyToOne
    @JoinColumn(name = "PROJEKT_PRONR", referencedColumnName = "PRONR")
	private Projekt projekt;

	public Long getFeNr() {
		return feNr;
	}

	public void setFeNr(Long feNr) {
		this.feNr = feNr;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Date getErstellt() {
		return erstellt;
	}

	public void setErstellt(Date erstellt) {
		this.erstellt = erstellt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Prioritaet getPrioritaet() {
		return prioritaet;
	}

	public void setPrioritaet(Prioritaet prioritaet) {
		this.prioritaet = prioritaet;
	}

//    private List<Kommentar> kommentarList = new ArrayList<Kommentar>();
}
