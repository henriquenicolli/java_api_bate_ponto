package com.bateponto.app.model.enums;

import lombok.Getter;

@Getter
public enum TipoRegistro {
    ENTRADA(1, "ENTRADA"),
    SAIDA(2, "SAIDA");

    private final int codigo;
    private final String descricao;

    TipoRegistro(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TipoRegistro fromCodigo(int codigo) {
        for (TipoRegistro e : values()) {
            if (e.codigo == codigo) {
                return e;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + codigo);
    }

    public static TipoRegistro fromString(String valor) {
        for (TipoRegistro e : values()) {
            if (e.descricao.equalsIgnoreCase(valor)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + valor);
    }

}
