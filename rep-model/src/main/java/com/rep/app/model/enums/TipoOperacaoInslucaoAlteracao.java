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

    public static TipoOperacaoInslucaoAlteracao fromTipoOperacao(final String tipoOperacao) {
        for (TipoOperacaoInslucaoAlteracao tipo : TipoOperacaoInslucaoAlteracao.values()) {
            if (tipo.getTipoOperacao().equals(tipoOperacao)) {
                return tipo;
            }
        }
        return null; // ou lançar uma exceção
    }

}
