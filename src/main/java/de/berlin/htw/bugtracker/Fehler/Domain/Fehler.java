package de.berlin.htw.bugtracker.Fehler.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import de.berlin.htw.bugtracker.Nutzer.Domain.Nutzer;
import de.berlin.htw.bugtracker.Status.Domain.Status;

/**
 * Created by JanKa on 12.10.2015.
 */
@Entity
@Table(name = "FEHLER")
public class Fehler {

	@TableGenerator(name = "bugGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "FEHLER_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "bugGen")
	@Id
	@Column(name = "FEHLER_ID")
	private Long fehler_Id;

	@Column(name = "FENR")
	private Long feNr;

	@Column(name = "BEZEICHNUNG", length = 64)
	private String bezeichnung;

	@Column(name = "BESCHREIBUNG", columnDefinition="TEXT")
	private String beschreibung;

	@Column(name = "ERSTELLT")
	private Date erstellt;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ERSTELLER")
	private Nutzer ersteller;	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "BEARBEITER")
	private Nutzer bearbeiter;	

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "STANR")
	private Status status;

	@Column(name = "PRIO")
	private int prioritaet;
	
	@Column(name ="AKTIV")
	private boolean aktiv;

	@ManyToOne
	@JoinColumn(name = "PROJEKT_PRONR", referencedColumnName = "PRONR")
	private Projekt projekt;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "fehler")
	private List<Kommentar> kommentarList = new ArrayList<Kommentar>();


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

	public int getPrioritaet() {
		return prioritaet;
	}

	public void setPrioritaet(int prioritaet) {
		this.prioritaet = prioritaet;
	}

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}

	public List<Kommentar> getKommentarList() {
		return kommentarList;
	}

	public void setKommentarList(List<Kommentar> kommentarList) {
		this.kommentarList = kommentarList;
	}

	public Nutzer getErsteller() {
		return ersteller;
	}

	public void setErsteller(Nutzer ersteller) {
		this.ersteller = ersteller;
	}

	public Nutzer getBearbeiter() {
		return bearbeiter;
	}

	public void setBearbeiter(Nutzer bearbeiter) {
		this.bearbeiter = bearbeiter;
	}

    public boolean getAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }
}
