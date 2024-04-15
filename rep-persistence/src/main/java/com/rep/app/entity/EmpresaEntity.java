package com.rep.app.entity;

import com.rep.app.converter.TipoOperacaoInslucaoAlteracaoConverter;
import com.rep.app.model.enums.TipoOperacaoInslucaoAlteracao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_EMPRESA")
public class EmpresaEntity {

    @Id
    @Column(name = "id_empresa", updatable = false, nullable = false)
    private String idEmpresa;

    @Column(name = "num_seq_registro")
    private int numSeqRegistro;

    @Column(name = "nome_empresa")
    private String nomeEmpresa;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "tipo_idef_empregador")
    private String tipoIdefEmpregador;

    @Column(name = "cnpj")
    private long cnpj;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cod_idef_cei")
    private String codIdefCei;

    @Column(name = "cod_idef_caepf")
    private long codIdefCaepf;

    @Column(name = "cod_idef_cno")
    private long codIdefCno;

    @Column(name = "data_hora_inclusao_alteracao")
    private LocalDateTime dataHoraInclusaoAlteracao;

    @Convert(converter = TipoOperacaoInslucaoAlteracaoConverter.class)
    @Column(name = "tipo_operacao_inclusao_alteracao")
    private TipoOperacaoInslucaoAlteracao tipoOperacaoInclusaoAlteracao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_telefone")
    private TelefoneEntity telefone;

    @ManyToOne
    @JoinColumn(name = "id_usuario_inclusao_alteracao")
    private UsuarioEntity usuarioInclusaoAlteracao;

    @PrePersist
    public void generateId() {
        idEmpresa = UUID.randomUUID().toString();
    }

}
