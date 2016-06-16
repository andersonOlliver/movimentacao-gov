/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.converter;

import br.com.bb.intranet.supermt.governo.model.Agencia;
import br.com.bb.intranet.supermt.governo.model.Cliente;
import br.com.bb.intranet.supermt.governo.repository.Clientes;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

    @Inject
    private Clientes clientes;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // TODO Auto-generated method stub
        Cliente retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.clientes.porId(new Long(value));
        }

        return retorno;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // TODO Auto-generated method stub
        if (value != null) {
            return ((Cliente) value).getId().toString();
        }
        return null;
    }
    
    
    
    
    
}
