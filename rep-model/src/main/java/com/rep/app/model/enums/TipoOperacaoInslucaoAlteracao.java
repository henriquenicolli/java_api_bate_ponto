package com.rep.app.model.enums;

public enum TipoOperacaoInslucaoAlteracao {

    INCLUSAO("I"),
    ALTERACAO("A"),
    EXCLUSAO("E");

    private String tipoOperacao;

    TipoOperacaoInslucaoAlteracao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }


}
