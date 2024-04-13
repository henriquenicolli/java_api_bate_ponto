package com.rep.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_REP_EVENTOS")
public class RepEventosEntity {

    @Id
    @Column(name = "id_rep_evento")
    private String idRepEvento;

    @Column(name = "numero_sequencial_registros")
    private String numeroSequencialRegistros;

    @Column(name = "data_hora_inclusao")
    private String dataHoraInclusao;

    @Column(name = "tipo_registro")
    private String tipoRegistro;

    @ManyToOne
    @JoinColumn(name = "id_info_ptrp")
    private InfoPtrpEntity infoPtrp;

}
