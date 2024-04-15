package com.rep.app.converter;

import com.rep.app.model.enums.TipoOperacaoInslucaoAlteracao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoOperacaoInslucaoAlteracaoConverter implements AttributeConverter<TipoOperacaoInslucaoAlteracao, String> {

    @Override
    public String convertToDatabaseColumn(TipoOperacaoInslucaoAlteracao attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getTipoOperacao();
    }

    @Override
    public TipoOperacaoInslucaoAlteracao convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return TipoOperacaoInslucaoAlteracao.valueOf(dbData);
    }
}