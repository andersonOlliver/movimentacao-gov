/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.converter;

import br.com.bb.intranet.supermt.governo.model.Registro;
import br.com.bb.intranet.supermt.governo.repository.Registros;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
@FacesConverter(forClass = Registro.class)
public class RegistroConverter implements Converter {

    @Inject
    private Registros registros;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // TODO Auto-generated method stub
        Registro retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.registros.porId(new Long(value));
        }

        return retorno;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // TODO Auto-generated method stub
        if (value != null) {
            return ((Registro) value).getId().toString();
        }
        return null;
    }
    
}
