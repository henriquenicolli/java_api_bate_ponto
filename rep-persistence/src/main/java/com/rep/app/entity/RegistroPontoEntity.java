package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "TBL_REGISTRO_PONTO")
public class RegistroPontoEntity {

    @Id
    @Column(name = "id_registro_ponto")
    private String idRegistroPonto;

    @Column(name = "num_seq_registro")
    private int numSeqRegistro;

    @Column(name = "num_seq_es_registro")
    private int numSeqEsRegistro;

    @Column(name = "data_marcacao_ponto")
    private LocalDate dataMarcacaoPonto;

    @Column(name = "hora_marcacao_ponto")
    private LocalTime horaMarcacaoPonto;

    @Column(name = "fuso_horario_marcacao")
    private String fusoHorarioMarcacao;

    @Column(name = "fuso_horario_registro")
    private String fusoHorarioRegistro;

    @Column(name = "data_hora_inclusao_registro")
    private LocalDateTime dataHoraInclusaoRegistro;

    @Column(name = "marcacao_online")
    private boolean marcacaoOnline;

    @Column(name = "cpf_funcionario")
    private String cpfFuncionario;

    @Column(name = "hash_registro")
    private byte[] hashRegistro;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "motivo_marcacao")
    private String motivoMarcacao;

    @ManyToOne
    @JoinColumn(name = "cod_idef_coletor")
    private ColetorRegistroEntity coletorRegistro;

    @ManyToOne
    @JoinColumn(name = "cod_tipo_marcao")
    private TipoMarcacaoEntity tipoMarcacao;

    @ManyToOne
    @JoinColumn(name = "cod_fonte_marcacao")
    private FonteMarcacaoEntity fonteMarcacao;

    @ManyToOne
    @JoinColumn(name = "id_empregado")
    private EmpregadoEntity empregado;

}
