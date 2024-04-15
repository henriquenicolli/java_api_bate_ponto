package com.rep.app.mapper;

import com.rep.app.entity.*;
import com.rep.app.model.dto.EmpregadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmpregadoMapper {

    EmpregadoMapper INSTANCE = Mappers.getMapper(EmpregadoMapper.class);

    @Mapping(target = "idEmpregado", ignore = true)
    @Mapping(target = "numSeqRegistro", source = "numSeqRegistro")
    @Mapping(target = "empNome", source = "empNome")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "dataAdmissao", source = "dataAdmissao")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "departamento", source = "departamento")
    @Mapping(target = "cargo", source = "cargo")
    @Mapping(target = "banco", source = "banco")
    @Mapping(target = "agencia", source = "agencia")
    @Mapping(target = "conta", source = "conta")
    @Mapping(target = "codIdefCtps", source = "codIdefCtps")
    @Mapping(target = "codIdefCaepf", source = "codIdefCaepf")
    @Mapping(target = "codIdefCno", source = "codIdefCno")
    @Mapping(target = "codMatriculaEsocial", source = "codMatriculaEsocial")
    @Mapping(target = "telefone", source = "idTelefone", qualifiedByName = "mapTelefoneIdToEntity")
    @Mapping(target = "horarioContratual", source = "codHorarioContratual", qualifiedByName = "mapHorarioContratualToEntity")
    @Mapping(target = "enderecoEmpresa", source = "idEmpresaEndereco", qualifiedByName = "mapEmpresaEnderecoIdToEntity")
    @Mapping(target = "empresa", source = "idEmpresa", qualifiedByName = "mapEmpresaIdToEntity")
    EmpregadoEntity toEntity(EmpregadoDTO dto);

    @Mapping(target = "idEmpregado", source = "idEmpregado")
    @Mapping(target = "numSeqRegistro", source = "numSeqRegistro")
    @Mapping(target = "empNome", source = "empNome")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "dataAdmissao", source = "dataAdmissao")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "departamento", source = "departamento")
    @Mapping(target = "cargo", source = "cargo")
    @Mapping(target = "banco", source = "banco")
    @Mapping(target = "agencia", source = "agencia")
    @Mapping(target = "conta", source = "conta")
    @Mapping(target = "codIdefCtps", source = "codIdefCtps")
    @Mapping(target = "codIdefCaepf", source = "codIdefCaepf")
    @Mapping(target = "codIdefCno", source = "codIdefCno")
    @Mapping(target = "codMatriculaEsocial", source = "codMatriculaEsocial")
    /*@Mapping(target = "idEmpresaEndereco", source = "idEmpresaEndereco")
    @Mapping(target = "codHorarioContratual", source = "codHorarioContratual")
    @Mapping(target = "idTelefone", source = "idTelefone")
    @Mapping(target = "idEmpresa", source = "idEmpresa")*/
    EmpregadoDTO toDto(EmpregadoEntity entity);

    @Named("mapEmpresaIdToEntity")
    default EmpresaEntity mapEmpresaIdToEntity(final String idEmpresa) {
        final EmpresaEntity empresa = new EmpresaEntity();
        empresa.setIdEmpresa(idEmpresa);
        return empresa;
    }

    @Named("mapTelefoneIdToEntity")
    default TelefoneEntity mapTelefoneIdToEntity(final String idTelefone) {
        final TelefoneEntity telefone = new TelefoneEntity();
        telefone.setIdTelefoneEmp(idTelefone);
        return telefone;
    }

    @Named("mapHorarioContratualToEntity")
    default HorarioContratualEntity mapHorarioContratualToEntity(final int codHorarioContratual) {
        final HorarioContratualEntity horarioContratual = new HorarioContratualEntity();
        horarioContratual.setCodHoraContratual(codHorarioContratual);
        return horarioContratual;
    }

    @Named("mapEmpresaEnderecoIdToEntity")
    default EmpresaEnderecoEntity mapEmpresaEnderecoIdToEntity(final String idEmpresaEndereco) {
        final EmpresaEnderecoEntity enderecoEmpresa = new EmpresaEnderecoEntity();
        enderecoEmpresa.setIdEndereco(idEmpresaEndereco);
        return enderecoEmpresa;
    }

}
