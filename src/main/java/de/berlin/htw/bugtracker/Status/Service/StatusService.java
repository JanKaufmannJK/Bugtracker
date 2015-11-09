package de.berlin.htw.bugtracker.Status.Service;

import java.util.List;

import de.berlin.htw.bugtracker.Status.Domain.Status;

public interface StatusService {
    
    public List<Status> selectFolgeStati(List<Long> folgeStatiStaNr);    
    
    public List<Status> selectAllStati();
    
    public Object findByStaNr(long staNr);
    
}
