package de.berlin.htw.domain;

/**
 * Created by JanKa on 12.10.2015.
 */
public enum Prioritaet {
    HOCH(1),
    MITTEL(2),
    NIEDRIG(3);

    private final int wert;
    private Prioritaet(int wert) {
        this.wert = wert;
    }

    public int getWert() {
        return wert;
    }
}
