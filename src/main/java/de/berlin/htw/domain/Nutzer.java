package de.berlin.htw.domain;

import javax.persistence.*;

/**
 * Created by JanKa on 26.10.2015.
 */

@Entity
@Table(name="NUTZER")
public class Nutzer {


    @TableGenerator(name = "bugGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "NUTZER_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "bugGen")
    @Id
    @Column(name = "PRONR")
    private Long nuNr;

    @Column(name="VORNAME", length=64)
    private String vorname;

    @Column(name="NAME", length=64)
    private String name;

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
