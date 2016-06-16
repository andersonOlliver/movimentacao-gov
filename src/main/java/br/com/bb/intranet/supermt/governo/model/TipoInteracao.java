package br.com.bb.intranet.supermt.governo.model;

public enum TipoInteracao {

    OPCAO1("opção 1"),
    OPCAO2("opção 2");

    private String valor;

    private TipoInteracao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
