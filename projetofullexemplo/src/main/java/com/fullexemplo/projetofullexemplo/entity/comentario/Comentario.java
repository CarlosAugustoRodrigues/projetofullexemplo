package com.fullexemplo.projetofullexemplo.entity.comentario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fullexemplo.projetofullexemplo.entity.os.OS;
import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
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
    private LocalDate dataComentario;

    @Column(nullable = false)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_colaborador", referencedColumnName = "id")
    @JsonIgnore
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "id_os", referencedColumnName = "id")
    @JsonIgnore
    private OS os;
}
