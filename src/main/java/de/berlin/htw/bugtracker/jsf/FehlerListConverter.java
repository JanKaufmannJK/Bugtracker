package de.berlin.htw.bugtracker.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.berlin.htw.bugtracker.Fehler.Domain.Fehler;
import de.berlin.htw.bugtracker.Fehler.Service.FehlerService;

@Component("fehlerListConverter")
public class FehlerListConverter implements Converter {

    @Autowired
    private FehlerService fehlerService;

    public FehlerListConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.isEmpty()) {
            return null;
        }
        Long fehler_Id = Long.parseLong(value);
        return fehlerService.findFehlerId(fehler_Id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().isEmpty()) {
            return "";
        }
        return String.valueOf(((Fehler) value).getFehler_Id());
       
    }
}