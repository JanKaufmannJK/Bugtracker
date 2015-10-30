package de.berlin.htw.service;

import java.util.List;

import de.berlin.htw.domain.Nutzer;

public interface NutzerService {
    
    public List<Nutzer> selectUsers();
    
    public Object findByNuNr(long nuNr);
    
}
