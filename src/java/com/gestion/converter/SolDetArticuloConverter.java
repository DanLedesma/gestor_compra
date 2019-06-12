package com.gestion.converter;

import com.gestion.compra.SolDetArticulo;
import com.gestion.facade.SolDetArticuloFacade;
import com.gestion.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "solDetArticuloConverter")
public class SolDetArticuloConverter implements Converter {

    private SolDetArticuloFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    com.gestion.compra.SolDetArticuloPK getKey(String value) {
        com.gestion.compra.SolDetArticuloPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new com.gestion.compra.SolDetArticuloPK();
        key.setIdSolicitud(Integer.parseInt(values[0]));
        key.setArticulo(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(com.gestion.compra.SolDetArticuloPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdSolicitud());
        sb.append(SEPARATOR);
        sb.append(value.getArticulo());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof SolDetArticulo) {
            SolDetArticulo o = (SolDetArticulo) object;
            return getStringKey(o.getSolDetArticuloPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SolDetArticulo.class.getName()});
            return null;
        }
    }

    private SolDetArticuloFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(SolDetArticuloFacade.class).get();
        return this.ejbFacade;
    }
}
