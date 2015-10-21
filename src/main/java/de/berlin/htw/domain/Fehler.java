package de.berlin.htw.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Created by JanKa on 12.10.2015.
 */
@Entity
@Table(name = "FEHLER")
public class Fehler {

	@TableGenerator(name = "proGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "FEHLER_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "proGen")
	@Id
	@Column(name ="FEHLER_ID")
	private Long fehler_id;

	@Column(name = "FENR")
	private Long feNr;

	@Column(name = "BEZEICHNUNG")
	private String bezeichnung;

	@Column(name = "BESCHREIBUNG")
	private String beschreibung;

	@Column(name = "ERSTELLT")
	private Date erstellt;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "PRIO")
	private String prioritaet;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrioritaet() {
		return prioritaet;
	}

	public void setPrioritaet(String prioritaet) {
		this.prioritaet = prioritaet;
	}

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}

	// private List<Kommentar> kommentarList = new ArrayList<Kommentar>();
}
