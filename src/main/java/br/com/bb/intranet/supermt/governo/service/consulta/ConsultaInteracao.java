/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.service.consulta;

import br.com.bb.intranet.supermt.governo.model.Interacao;
import br.com.bb.intranet.supermt.governo.repository.Interacoes;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Olliver
 */
public class ConsultaInteracao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Interacoes interacaoRepository;
    
    public TreeNode gerarArvore(String mci){
        List<Interacao> consulta = this.interacaoRepository.porMci(mci);
        
        TreeNode root = new DefaultTreeNode();// parado aki
        
        return root;
    }
    
}
