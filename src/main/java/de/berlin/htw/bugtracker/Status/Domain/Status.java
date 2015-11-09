package de.berlin.htw.bugtracker.Status.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Created by JanKa on 26.10.2015.
 */

@Entity
@Table(name = "STATUS")
public class Status {

	@TableGenerator(name = "bugGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "STATUS_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "bugGen")
	@Id
	@Column(name = "STANR")
	private Long staNr;

	@Column(name = "BEZEICHNUNG", length = 64)
	private String bezeichnung;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "STATUS_NACHFOLGER", joinColumns = @JoinColumn(name = "STANR") )
	@Column(name = "NACHFOLGER")
	private List<Long> statusInfo = new ArrayList<Long>();

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (staNr != null ? staNr.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Status)) {
			return false;
		}
		Status other = (Status) object;
		if ((this.staNr == null && other.staNr != null) || (this.staNr != null && !this.staNr.equals(other.staNr))) {
			return false;
		}
		return true;
	}

	public List<Long> getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(List<Long> statusInfo) {
		this.statusInfo = statusInfo;
	}

	public Long getStaNr() {
		return staNr;
	}

	public void setStaNr(Long staNr) {
		this.staNr = staNr;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

}
