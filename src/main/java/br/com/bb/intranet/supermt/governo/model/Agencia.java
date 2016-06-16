package br.com.bb.intranet.supermt.governo.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "agencia")
public class Agencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(max = 5)
    @Column(nullable = false, length = 5, unique = true)
    private String prefixo;

    @Size(max = 100)
    @Column(length = 100)
    private String nome;

    @Size(max = 5)
    @Column(length = 5)
    private String dependencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.prefixo);
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
        final Agencia other = (Agencia) obj;
        if (!Objects.equals(this.prefixo, other.prefixo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
