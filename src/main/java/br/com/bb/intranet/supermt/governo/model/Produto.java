package br.com.bb.intranet.supermt.governo.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(max = 100)
    @Column(length = 100, nullable = false)
    private String nome;

    @Size(max = 60)
    @Column(length = 60)
    private String instrucaoNormativa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstrucaoNormativa() {
        return instrucaoNormativa;
    }

    public void setInstrucaoNormativa(String instrucaoNormativa) {
        this.instrucaoNormativa = instrucaoNormativa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
