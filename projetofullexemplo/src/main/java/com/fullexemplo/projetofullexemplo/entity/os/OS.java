package com.fullexemplo.projetofullexemplo.entity.os;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.entity.comentario.Comentario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
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

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDate abertura;

    private LocalDate encerramento;

    @ManyToOne
    @JoinColumn(name = "id_colaborador", referencedColumnName = "id")
    @JsonIgnore
    private Colaborador colaborador;


    @OneToMany(mappedBy = "os", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Comentario> listaCom = new HashSet<>();
}
