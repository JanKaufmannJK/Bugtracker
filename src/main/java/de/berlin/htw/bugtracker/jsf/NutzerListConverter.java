package de.berlin.htw.bugtracker.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.berlin.htw.bugtracker.Nutzer.Domain.Nutzer;
import de.berlin.htw.bugtracker.Nutzer.Service.NutzerService;

@Component("nutzerListConverter")
public class NutzerListConverter implements Converter {

    @Autowired
    private NutzerService nutzerService;

    public NutzerListConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.isEmpty()) {
            return null;
        }
        Long nuNr = Long.parseLong(value);
        return nutzerService.findByNuNr(nuNr);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().isEmpty()) {
            return "";
        }
        return String.valueOf(((Nutzer) value).getNuNr());
       
    }
}