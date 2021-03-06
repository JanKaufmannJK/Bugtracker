package de.berlin.htw.bugtracker.Fehler.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Created by JanKa on 12.10.2015.
 */

@Entity
@Table(name = "PROJEKT")
public class Projekt {

	public Projekt() {
	}

	public Projekt(Long proNr, String bezeichnung) {
		this.proNr = proNr;
		this.bezeichnung = bezeichnung;
	}

	@TableGenerator(name = "bugGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "PROJEKT_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "bugGen")
	@Id
	@Column(name = "PRONR")
	private Long proNr;

	@Column(name = "BEZEICHNUNG", length = 64)
	private String bezeichnung;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "projekt")
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
