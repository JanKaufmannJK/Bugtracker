package de.berlin.htw.gui.page.Status;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Status;
import de.berlin.htw.service.StatusService;

@Component
@Scope("singleton")
public class StatusBean {
    
    private List<Status> statusList;
    
    @Autowired
    private StatusService statusService;
    
    @PostConstruct
    private void init() {
        setStatusList(statusService.selectAllStati());
    }
    
    public List<Status> getStatusList() {
        return statusList;
    }
    
    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }
}
