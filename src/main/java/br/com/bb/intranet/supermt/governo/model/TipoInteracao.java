package br.com.bb.intranet.supermt.governo.model;

public enum TipoInteracao {

    INTERACAO("Interação"),
    REUNIAO_VISITA("Reunião/Visita"),
    EVENTO("Evento"),
    CONTATO_VIRTUAL("Contato Virtual");

    private String valor;

    private TipoInteracao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
