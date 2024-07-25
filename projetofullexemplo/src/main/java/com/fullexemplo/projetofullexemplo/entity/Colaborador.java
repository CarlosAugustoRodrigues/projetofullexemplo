package com.fullexemplo.projetofullexemplo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_COLABORADORES")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String cargo;
    private String setor;
    private String pin;

    @OneToMany(mappedBy = "colaborador")
    private List<OS> ordens_servico;

    @OneToMany(mappedBy = "colaborador")
    private List<Comentario> comentarios;

}
