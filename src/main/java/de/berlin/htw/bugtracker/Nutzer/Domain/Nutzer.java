package de.berlin.htw.bugtracker.Nutzer.Domain;

import javax.persistence.*;

/**
 * Created by JanKa on 26.10.2015.
 */

@Entity
@Table(name = "NUTZER")
public class Nutzer {
    
    @TableGenerator(name = "bugGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "NUTZER_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "bugGen")
    @Id
    @Column(name = "NUNR")
    private Long nuNr;
    
    @Column(name = "VORNAME", length = 64)
    private String vorname;
    
    @Column(name = "NAME", length = 64)
    private String name;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nuNr != null ? nuNr.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Nutzer)) {
            return false;
        }
        Nutzer other = (Nutzer) object;
        if ((this.nuNr == null && other.nuNr != null) || (this.nuNr != null && !this.nuNr.equals(other.nuNr))) {
            return false;
        }
        return true;
    }
    
    public Long getNuNr() {
        return nuNr;
    }
    
    public void setNuNr(Long nuNr) {
        this.nuNr = nuNr;
    }
    
    public String getVorname() {
        return vorname;
    }
    
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
