package com.fullexemplo.projetofullexemplo.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
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
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @OneToMany(mappedBy = "os", fetch = FetchType.EAGER)
    private Set<Comentario> listCom = new HashSet<>();


}
