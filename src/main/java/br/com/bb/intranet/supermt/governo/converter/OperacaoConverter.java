package br.com.bb.intranet.supermt.governo.converter;

import br.com.bb.intranet.supermt.governo.model.Funcionario;
import br.com.bb.intranet.supermt.governo.model.Operacao;
import br.com.bb.intranet.supermt.governo.repository.Operacoes;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Olliver
 */
@FacesConverter(forClass = Operacao.class)
public class OperacaoConverter implements Converter {

    @Inject
    private Operacoes operacoes;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // TODO Auto-generated method stub
        Operacao retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.operacoes.porId(new Long(value));
        }

        return retorno;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // TODO Auto-generated method stub
        if (value != null) {
            return ((Operacao) value).getId().toString();
        }
        return null;
    }
    
    
}
