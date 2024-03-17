package com.bateponto.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "TBL_REGISTRO_PONTO")
public class RegistroPontoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_registro_ponto")
    private long idRegistroPonto;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    private FuncionarioEntity funcionarioEntity;

    @Column(name = "data_hora_registro_ponto")
    private LocalDateTime dataHoraRegistroPonto;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @ManyToOne
    @JoinColumn(name = "id_tipo_registro_ponto", referencedColumnName = "id_tipo_registro_ponto")
    private TipoRegistroPontoEntity tipoRegistroPontoEntity;

}
