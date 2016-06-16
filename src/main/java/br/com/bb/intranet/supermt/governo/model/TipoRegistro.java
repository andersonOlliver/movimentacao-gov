package br.com.bb.intranet.supermt.governo.model;

public enum TipoRegistro {

    ATUALIZACAO("Atualizaco"),
    INSERCAO("Inserção");
    
    private String valor;

    private TipoRegistro(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
