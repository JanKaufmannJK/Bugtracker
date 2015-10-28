package de.berlin.htw.gui.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Status;
import de.berlin.htw.service.BugtrackerService;

@Component("statusListConverter")
public class StatusListConverter implements Converter {

    @Autowired
    private BugtrackerService bs;

    public StatusListConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.isEmpty()) {
            return null;
        }
        Long staNr = Long.parseLong(value);
        return bs.findByStaNr(staNr);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().isEmpty()) {
            return "";
        }
        return String.valueOf(((Status) value).getStaNr());
       
    }
}