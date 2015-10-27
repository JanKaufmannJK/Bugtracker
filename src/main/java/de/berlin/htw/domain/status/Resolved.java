package de.berlin.htw.domain.status;

import java.util.ArrayList;
import java.util.List;

import de.berlin.htw.domain.Status;

public class Resolved extends Status{
    
    private List<String> vorgaenger = new ArrayList<String>();
    private List<String> nachfolger = new ArrayList<String>();
    
    public Resolved(){
        vorgaenger.add("WaitingForTriage");
        vorgaenger.add("InProgress");
        vorgaenger.add("Reopened");
        nachfolger.add("Closed");
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
