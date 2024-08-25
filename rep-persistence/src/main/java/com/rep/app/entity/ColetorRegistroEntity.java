package com.rep.app.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_COLETOR_REGISTRO")
public class ColetorRegistroEntity {

    @Id
    @Column(name = "cod_idef_coletor_registro")
    private int codIdefColetorRegistro;

    @Column(name = "descricao")
    private String descricao;

}
