/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.consulta;

import br.com.bb.intranet.supermt.governo.model.Estagio;
import br.com.bb.intranet.supermt.governo.repository.Estagios;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
public class ConsultaEstagioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Estagios estagioRepository;
    
    private List<Estagio> estagios;
    
    public void consultar(){
        this.estagios = estagioRepository.todos();
    }

    public List<Estagio> getEstagios() {
        return estagios;
    }
}
