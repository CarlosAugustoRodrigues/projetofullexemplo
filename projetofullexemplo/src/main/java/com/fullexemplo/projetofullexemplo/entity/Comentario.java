package com.fullexemplo.projetofullexemplo.entity;

import com.fullexemplo.projetofullexemplo.dtos.comentario.ComReqRecordDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_COMENTARIO")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private LocalDate data_comentario;

    @Column(nullable = false)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_os", referencedColumnName = "id")
    private OS comOs;

    @ManyToOne
    @JoinColumn(name = "id_colaborador", referencedColumnName = "id")
    private Colaborador comCol;

    public Comentario(ComReqRecordDTO data) {
        setData_comentario(data.dataComentario());
        setComentario(data.comentario());
        setComOs(data.os());
        setComCol(data.colaborador());
    }
}
