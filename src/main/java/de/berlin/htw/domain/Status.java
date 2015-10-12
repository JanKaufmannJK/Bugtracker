package de.berlin.htw.domain;

/**
 * Created by JanKa on 12.10.2015.
 * https://www.mantisbt.org/manual/admin.lifecycle.status.html
 */
public enum Status {
    NEU             ('N'),
    ANERKANNT       ('A'),
    BESTAETIGT      ('B'),
    ZUGEWIESEN      ('Z'),
    GELOEST         ('G'),
    GESCHLOSSEN     ('G');

    private final char wert;
    private Status (char wert) {
        this.wert = wert;
    }

    public char getWert(){
        return wert;
    }


}
