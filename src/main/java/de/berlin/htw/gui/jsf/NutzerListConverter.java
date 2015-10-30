package de.berlin.htw.gui.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.berlin.htw.domain.Nutzer;
import de.berlin.htw.domain.Status;
import de.berlin.htw.service.NutzerService;
import de.berlin.htw.service.StatusService;

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