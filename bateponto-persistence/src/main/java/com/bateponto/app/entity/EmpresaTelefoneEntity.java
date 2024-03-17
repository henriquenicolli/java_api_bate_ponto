package com.bateponto.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "TBL_EMPR_TELF")
public class EmpresaTelefoneEntity {

    @Id
    @Column(name = "id_telefone_emp")
    private Integer idTelefoneEmp;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cod_operadora")
    private String codOperadora;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    private EmpresaEntity empresa;

}