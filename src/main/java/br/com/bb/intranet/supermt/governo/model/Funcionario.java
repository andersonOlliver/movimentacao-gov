package br.com.bb.intranet.supermt.governo.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
public class Funcionario implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(max = 10)
    @Column(nullable = false, length = 10, unique = true)
    private String chave;

    @Size(max = 15)
    @Column(length = 15, nullable = false)
    private String apelido;

    @NotEmpty
    @Size(max = 60)
    @Column(length = 60, nullable = false)
    private String nomeCompleto;

    @Size(max = 150)
    @Column(length = 150)
    private String caminhoImagem;

    @ManyToOne
    @JoinColumn(name = "agencia_id")
    private Agencia agencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.chave);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.chave, other.chave)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
