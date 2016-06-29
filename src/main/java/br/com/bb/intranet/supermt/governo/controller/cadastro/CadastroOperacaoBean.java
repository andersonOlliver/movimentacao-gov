/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.cadastro;

import br.com.bb.intranet.supermt.governo.controller.UsuarioAcesso;
import br.com.bb.intranet.supermt.governo.model.Cliente;
import br.com.bb.intranet.supermt.governo.model.Funcionario;
import br.com.bb.intranet.supermt.governo.model.Operacao;
import br.com.bb.intranet.supermt.governo.repository.Clientes;
import br.com.bb.intranet.supermt.governo.repository.Funcionarios;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.service.cadastro.CadastroFuncionario;
import br.com.bb.intranet.supermt.governo.service.cadastro.CadastroOperacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Olliver
 */
@Named
@ViewScoped
public class CadastroOperacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroOperacao cadastro;

    @Inject
    private CadastroFuncionario cadastroFuncionario;

    @Inject
    private Clientes clienteRepository;

    @Inject
    private Funcionarios funcionarioRepository;

    List<Funcionario> dados = new ArrayList<Funcionario>();
    private List<UsuarioAcesso> usuarios;
    private UsuarioAcesso usuario;
    private Operacao operacao;
    private Cliente cliente;
    private String mci;

    public void prepararCadastro() {
        this.operacao = new Operacao();
        this.usuario = new UsuarioAcesso();
        this.usuarios = new ArrayList<UsuarioAcesso>();
        if (mci != null) {
            this.operacao.setCliente(this.clienteRepository.porMci(mci));
        }

    }

    public List<String> pesquisarChaves(String chave) {
        return this.funcionarioRepository.chavesQueContem(chave);
    }

    public List<String> pesquisarMci(String mci) {
        return this.clienteRepository.mciQueContenha(mci);
    }

    /*
        inserir ou atualizar as informações dos usuarios no banco
     */
    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("Entrou metodo");
        System.out.println(this.operacao);
        System.out.println(this.usuarios);
        try {

            this.incluiAcessos();
            List<Funcionario> dadosDoBanco = new ArrayList();
            for (UsuarioAcesso funcionario : usuarios) {
                dadosDoBanco.add(this.funcionarioRepository.porChave(funcionario.getChave()));
            }
            operacao.setFuncionarioAcesso(dadosDoBanco);
            Operacao aux = this.cadastro.atualizar(operacao);
            System.out.println(aux.getFuncionarioAcesso());
            this.prepararCadastro();

            context.addMessage(null, new FacesMessage("Operação salva com sucesso!"));
        } catch (NegocioException e) {

            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }

    private void incluiAcessos() {
        for (UsuarioAcesso funcionario : usuarios) {

            Funcionario busca = this.funcionarioRepository.porChave(funcionario.getChave());
            if (busca == null) {
                Funcionario obj = new Funcionario();
                obj.setChave(funcionario.getChave());
                obj.setNomeCompleto(funcionario.getNome());
                obj.setApelido(" - ");

                try {
                    this.cadastroFuncionario.salvar(obj);
                } catch (NegocioException ex) {
                    System.out.println("Erro ao persistir!");
                }
            }

        }
    }

    public void createNew() {
        if (usuarios.contains(usuario)) {
            FacesMessage msg = new FacesMessage("Duplicado", "Esse usuario já foi inserido!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            usuarios.add(usuario);
            this.usuario = new UsuarioAcesso();
        }
    }

    public String reinit() {
        this.usuario = new UsuarioAcesso();

        return null;
    }

    public List<UsuarioAcesso> getUsuarios() {
        return usuarios;
    }

    public UsuarioAcesso getUsuario() {
        return usuario;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMci() {
        return mci;
    }

    public void setMci(String mci) {
        this.mci = mci;
    }

}
