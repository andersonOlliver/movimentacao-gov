/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.converter;

import br.com.bb.intranet.supermt.governo.model.Agencia;
import br.com.bb.intranet.supermt.governo.model.Estagio;
import br.com.bb.intranet.supermt.governo.repository.Estagios;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
@FacesConverter(forClass = Estagio.class)
public class EstagioConverter implements Converter {

    @Inject
    private Estagios estagios;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // TODO Auto-generated method stub
        Estagio retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.estagios.porId(new Long(value));
        }

        return retorno;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // TODO Auto-generated method stub
        if (value != null) {
            return ((Estagio) value).getId().toString();
        }
        return null;
    }
    
}
