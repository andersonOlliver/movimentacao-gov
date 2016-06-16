package br.com.bb.intranet.supermt.governo.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class Registro {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "interacao_id")
    private Interacao interacao;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoRegistro tipoRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Interacao getInteracao() {
        return interacao;
    }

    public void setInteracao(Interacao interacao) {
        this.interacao = interacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public TipoRegistro getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(TipoRegistro tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Registro other = (Registro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
