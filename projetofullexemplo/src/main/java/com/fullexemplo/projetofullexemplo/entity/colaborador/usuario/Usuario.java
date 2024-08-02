package com.fullexemplo.projetofullexemplo.entity.colaborador.usuario;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
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
    @JoinColumn(name = "info_colaborador", referencedColumnName = "id")
    @JsonIgnore
    private Colaborador colaborador;

}


