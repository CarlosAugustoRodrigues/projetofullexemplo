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
    @JoinColumn(name = "id_os")
    private OS os;

    @ManyToOne
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    public Comentario(ComReqRecordDTO data) {
        setData_comentario(data.data_comentario());
        setComentario(data.comentario());
        setOs(data.os());
        setColaborador(data.colaborador());
    }
}
