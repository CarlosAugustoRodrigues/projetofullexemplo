package com.fullexemplo.projetofullexemplo.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_ORDEM_SERVIÇOS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class OS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_executor")
    private Colaborador executor;

    @ManyToOne
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    private LocalDate abertura;

    private LocalDate encerramento;

    @OneToMany(mappedBy = "os")
    private List<Comentario> comentarios;


}
