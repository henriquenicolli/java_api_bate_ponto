package com.rep.app.mapper.commons;

import com.rep.app.entity.ColetorRegistroEntity;
import com.rep.app.entity.EmpregadoEntity;
import com.rep.app.entity.FonteMarcacaoEntity;
import com.rep.app.entity.TipoMarcacaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public abstract class RegistroPontoCommonsMapper {

    @Named("mapColetorRegistroToInteger")
    public Integer mapColetorRegistroToInteger(ColetorRegistroEntity entity) {
        return entity != null ? entity.getCodIdefColetorRegistro() : null;
    }

    @Named("mapTipoMarcacaoToString")
    public String mapTipoMarcacaoToString(TipoMarcacaoEntity entity) {
        return entity != null ? entity.getCodTipoMarcacao() : null;
    }

    @Named("mapFonteMarcacaoToString")
    public String mapFonteMarcacaoToString(FonteMarcacaoEntity entity) {
        return entity != null ? entity.getCodFonteMarcacao() : null;
    }

    @Named("mapEmpregadoToString")
    public String mapEmpregadoToString(EmpregadoEntity entity) {
        return entity != null ? entity.getIdEmpregado() : null;
    }

    @Named("mapColetorRegistro")
    public ColetorRegistroEntity mapColetorRegistro(Integer value) {
        final ColetorRegistroEntity entity = new ColetorRegistroEntity();
        entity.setCodIdefColetorRegistro(value);
        return entity;
    }

    @Named("mapTipoMarcacao")
    public TipoMarcacaoEntity mapTipoMarcacao(String value) {
        final TipoMarcacaoEntity tipoMarcacaoEntity = new TipoMarcacaoEntity();
        tipoMarcacaoEntity.setCodTipoMarcacao(value);
        return tipoMarcacaoEntity;
    }

    @Named("mapFonteMarcacao")
    public FonteMarcacaoEntity mapFonteMarcacao(String value) {
        final FonteMarcacaoEntity fonteMarcacaoEntity = new FonteMarcacaoEntity();
        fonteMarcacaoEntity.setCodFonteMarcacao(value);
        return fonteMarcacaoEntity;
    }

    @Named("mapEmpregado")
    public EmpregadoEntity mapEmpregado(String value) {
        final EmpregadoEntity empregadoEntity = new EmpregadoEntity();
        empregadoEntity.setIdEmpregado(value);
        return empregadoEntity;
    }

}
