package com.bateponto.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "TBL_FUNC_REMUNERACAO")
public class FuncionarioRemuneracaoEntity {

    @Id
    @Column(name = "id_func_remuneracao")
    private Integer idFuncRemuneracao;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    private FuncionarioEntity funcionarioEntity;

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
