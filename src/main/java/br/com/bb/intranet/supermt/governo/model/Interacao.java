package br.com.bb.intranet.supermt.governo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "interacao")
public class Interacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoInteracao tipoInteracao;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Cliente empresa;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario cadastrante;

    @NotEmpty
    @Size(max = 250)
    @Column(length = 250, nullable = false)
    private String titulo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_interacao", nullable = false)
    private Date data;

    @NotNull
    @Size(max = 3000)
    @Column(name = "valor_noticia", length = 3000)
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Oportunidade> oportunidades;
    
    @ManyToOne
    @JoinColumn(name="operacao_id")
    private Operacao operacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoInteracao getTipoInteracao() {
        return tipoInteracao;
    }

    public void setTipoInteracao(TipoInteracao tipoInteracao) {
        this.tipoInteracao = tipoInteracao;
    }

    public Cliente getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Cliente empresa) {
        this.empresa = empresa;
    }

    public Funcionario getCadastrante() {
        return cadastrante;
    }

    public void setCadastrante(Funcionario cadastrante) {
        this.cadastrante = cadastrante;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(List<Oportunidade> oportunidades) {
        this.oportunidades = oportunidades;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Interacao other = (Interacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
