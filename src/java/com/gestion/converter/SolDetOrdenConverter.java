package com.gestion.converter;

import com.gestion.compra.SolDetOrden;
import com.gestion.facade.SolDetOrdenFacade;
import com.gestion.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "solDetOrdenConverter")
public class SolDetOrdenConverter implements Converter {

    private SolDetOrdenFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    com.gestion.compra.SolDetOrdenPK getKey(String value) {
        com.gestion.compra.SolDetOrdenPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new com.gestion.compra.SolDetOrdenPK();
        key.setIdOrden(Integer.parseInt(values[0]));
        key.setArticulo(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(com.gestion.compra.SolDetOrdenPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdOrden());
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
        if (object instanceof SolDetOrden) {
            SolDetOrden o = (SolDetOrden) object;
            return getStringKey(o.getSolDetOrdenPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SolDetOrden.class.getName()});
            return null;
        }
    }

    private SolDetOrdenFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(SolDetOrdenFacade.class).get();
        return this.ejbFacade;
    }
}
