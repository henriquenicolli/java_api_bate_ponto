package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "TBL_EMPREGADO_REMUNERACAO")
public class EmpregadoRemuneracaoEntity {

    @Id
    @Column(name = "id_emprg_remuneracao")
    private Integer idEmpregadoRemuneracao;

    @ManyToOne
    @JoinColumn(name = "id_empregado", referencedColumnName = "id_empregado")
    private EmpregadoEntity empregadoEntity;

    @Column(name = "vigencia")
    private String vigencia;

    @ManyToOne
    @JoinColumn(name = "id_tipo_remuneracao", referencedColumnName = "id_tipo_remuneracao")
    private TipoRemuneracaoEntity tipoRemuneracaoEntity;

    @Column(name = "base")
    private String base;

    @Column(name = "unidade")
    private Integer unidade;

    @Column(name = "proventos")
    private Double proventos;

    @Column(name = "descontos")
    private Double descontos;

}
