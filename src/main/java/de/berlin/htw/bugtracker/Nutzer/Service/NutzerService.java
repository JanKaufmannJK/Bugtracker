package de.berlin.htw.bugtracker.Nutzer.Service;

import java.util.List;

import de.berlin.htw.bugtracker.Nutzer.Domain.Nutzer;

public interface NutzerService {
    
    public List<Nutzer> selectUsers();
    
    public Object findByNuNr(long nuNr);
    
}
