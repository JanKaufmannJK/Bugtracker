package de.berlin.htw.service;

import java.util.List;

import de.berlin.htw.domain.Status;

public interface StatusService {
    
    public List<Status> selectFolgeStati(List<Long> folgeStatiStaNr);    
    
    public List<Status> selectAllStati();
    
    public Object findByStaNr(long staNr);
    
}
