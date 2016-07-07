/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.consulta;

import br.com.bb.intranet.supermt.governo.model.Cliente;
import br.com.bb.intranet.supermt.governo.model.Interacao;
import br.com.bb.intranet.supermt.governo.repository.Clientes;
import br.com.bb.intranet.supermt.governo.repository.Interacoes;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Olliver
 */
@Named
@ViewScoped
public class ConsultaInteracaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Interacoes interacaoRepository;

    @Inject
    private Clientes clienteRepository;

    private List<Interacao> interacoes;

    private String mci;
    private Cliente cliente;
    private TreeNode root;

    public void consultar() {
        this.interacoes = interacaoRepository.porMci(mci);
        this.cliente = clienteRepository.porMci(mci);
    }

    public List<Interacao> getInteracoes() {
        return interacoes;
    }

    public String getMci() {
        return mci;
    }

    public void setMci(String mci) {
        this.mci = mci;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TreeNode getRoot() {
        return root;
    }

}
