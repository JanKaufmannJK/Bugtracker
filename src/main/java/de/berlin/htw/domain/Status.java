package de.berlin.htw.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

}
