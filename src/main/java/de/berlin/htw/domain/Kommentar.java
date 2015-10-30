package de.berlin.htw.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Created by JanKa on 12.10.2015.
 */

@Entity
@Table(name = "KOMMENTAR")
public class Kommentar {

	@TableGenerator(name = "bugGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "KOMMENTAR_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "bugGen")
	@Id
	@Column(name ="KOMMENTAR_ID")
	private Long koId;
	
	@Column(name ="KONR")
    private Long koNr;

	@Column(name ="ERSTELLT")
    private Date erstellt;

	@Column(name ="TEXT", columnDefinition="TEXT")
    private String text;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "NUNR")
	private Nutzer nutzer;
	
	public Nutzer getNutzer() {
		return nutzer;
	}

	public void setNutzer(Nutzer nutzer) {
		this.nutzer = nutzer;
	}

	public Long getKoId() {
		return koId;
	}
	
	@ManyToOne
	@JoinColumn(name = "FEHLER_FEID", referencedColumnName = "FEHLER_ID")
	private Fehler fehler;

	public void setKoId(Long koId) {
		this.koId = koId;
	}

	public Long getKoNr() {
		return koNr;
	}

	public void setKoNr(Long koNr) {
		this.koNr = koNr;
	}

	public Date getErstellt() {
		return erstellt;
	}

	public void setErstellt(Date erstellt) {
		this.erstellt = erstellt;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Fehler getFehler() {
		return fehler;
	}

	public void setFehler(Fehler fehler) {
		this.fehler = fehler;
	}
}
