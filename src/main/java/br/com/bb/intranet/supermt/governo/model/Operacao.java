package br.com.bb.intranet.supermt.governo.model;

import br.com.bb.intranet.supermt.governo.validation.DecimalPositivo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "operacao")
public class Operacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Funcionario> funcionariosAcesso;

    @DecimalPositivo
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal valorRequisitado;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Interacao> interacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Funcionario> getFuncionariosAcesso() {
        return funcionariosAcesso;
    }

    public void setFuncionariosAcesso(List<Funcionario> funcionariosAcesso) {
        this.funcionariosAcesso = funcionariosAcesso;
    }

    public BigDecimal getValorRequisitado() {
        return valorRequisitado;
    }

    public void setValorRequisitado(BigDecimal valorRequisitado) {
        this.valorRequisitado = valorRequisitado;
    }

    public List<Interacao> getInteracoes() {
        return interacoes;
    }

    public void setInteracoes(List<Interacao> interacoes) {
        this.interacoes = interacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Operacao other = (Operacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
