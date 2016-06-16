/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.converter;

import br.com.bb.intranet.supermt.governo.model.Produto;
import br.com.bb.intranet.supermt.governo.model.Registro;
import br.com.bb.intranet.supermt.governo.repository.Produtos;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

    @Inject
    private Produtos produtos;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // TODO Auto-generated method stub
        Produto retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.produtos.porId(new Long(value));
        }

        return retorno;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // TODO Auto-generated method stub
        if (value != null) {
            return ((Produto) value).getId().toString();
        }
        return null;
    }
    
}
