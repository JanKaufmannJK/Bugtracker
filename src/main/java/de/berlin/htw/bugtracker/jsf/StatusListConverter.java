package de.berlin.htw.bugtracker.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.berlin.htw.bugtracker.Status.Domain.Status;
import de.berlin.htw.bugtracker.Status.Service.StatusService;

@Component("statusListConverter")
public class StatusListConverter implements Converter {

    @Autowired
    private StatusService statusService;

    public StatusListConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.isEmpty()) {
            return null;
        }
        Long staNr = Long.parseLong(value);
        return statusService.findByStaNr(staNr);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().isEmpty()) {
            return "";
        }
        return String.valueOf(((Status) value).getStaNr());
       
    }
}