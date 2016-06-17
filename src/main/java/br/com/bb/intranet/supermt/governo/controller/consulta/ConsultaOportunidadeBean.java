/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.consulta;

import br.com.bb.intranet.supermt.governo.model.Oportunidade;
import br.com.bb.intranet.supermt.governo.repository.Oportunidades;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Olliver
 */
@Named
@ViewScoped
public class ConsultaOportunidadeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Oportunidades oportunidadeRepository;
    
    private List<Oportunidade> oportunidades;
    
    public void consultar(){
        this.oportunidades = oportunidadeRepository.todas();
    }

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }
    
}
