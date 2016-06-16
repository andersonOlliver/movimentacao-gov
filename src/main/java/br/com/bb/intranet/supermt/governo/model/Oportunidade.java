package br.com.bb.intranet.supermt.governo.model;

import br.com.bb.intranet.supermt.governo.validation.DecimalPositivo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "oportunidade")
public class Oportunidade implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(max = 100)
    @Column(length = 100, nullable = false)
    private String titulo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_fechamento", nullable = false)
    private Date previsaoFechamento;

    @DecimalPositivo
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal valorOportunidade;

    @ManyToOne
    @JoinColumn(name = "estagio_id")
    private Estagio estagio;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProbabilidadeSucesso probabilidadeSucesso;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @NotNull
    @Size(max = 3000)
    @Column(name = "valor_noticia", length = 3000)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "interacao_id")
    private Interacao interacaoPai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getPrevisaoFechamento() {
        return previsaoFechamento;
    }

    public void setPrevisaoFechamento(Date previsaoFechamento) {
        this.previsaoFechamento = previsaoFechamento;
    }

    public BigDecimal getValorOportunidade() {
        return valorOportunidade;
    }

    public void setValorOportunidade(BigDecimal valorOportunidade) {
        this.valorOportunidade = valorOportunidade;
    }

    public Estagio getEstagio() {
        return estagio;
    }

    public void setEstagio(Estagio estagio) {
        this.estagio = estagio;
    }

    public ProbabilidadeSucesso getProbabilidadeSucesso() {
        return probabilidadeSucesso;
    }

    public void setProbabilidadeSucesso(ProbabilidadeSucesso probabilidadeSucesso) {
        this.probabilidadeSucesso = probabilidadeSucesso;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Interacao getInteracaoPai() {
        return interacaoPai;
    }

    public void setInteracaoPai(Interacao interacaoPai) {
        this.interacaoPai = interacaoPai;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Oportunidade other = (Oportunidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
