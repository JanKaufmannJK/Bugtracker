package de.berlin.htw.domain.status;

import java.util.ArrayList;
import java.util.List;

import de.berlin.htw.domain.Status;

public class Closed extends Status {
    
    private List<String> vorgaenger = new ArrayList<String>();
    private List<String> nachfolger = new ArrayList<String>();
    
    public Closed() {
        this.vorgaenger.add("Reopened");
        this.vorgaenger.add("Resolved");
        this.vorgaenger.add("InProgress");
    }
    
    public List<String> getVorgaenger() {
        return vorgaenger;
    }
    
    public void setVorgaenger(List<String> vorgaenger) {
        this.vorgaenger = vorgaenger;
    }
    
    public List<String> getNachfolger() {
        return nachfolger;
    }
    
    public void setNachfolger(List<String> nachfolger) {
        this.nachfolger = nachfolger;
    }
}
