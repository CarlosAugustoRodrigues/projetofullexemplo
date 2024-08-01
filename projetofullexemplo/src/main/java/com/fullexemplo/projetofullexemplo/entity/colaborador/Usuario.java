package com.fullexemplo.projetofullexemplo.entity.colaborador;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "TB_USUARIOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String matricula;

    @Column(nullable = false)
    private String pin;

    @OneToOne
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

}
