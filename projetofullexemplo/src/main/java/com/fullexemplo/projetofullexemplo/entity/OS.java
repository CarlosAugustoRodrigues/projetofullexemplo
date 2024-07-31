package com.fullexemplo.projetofullexemplo.entity;

import com.fullexemplo.projetofullexemplo.dtos.os.OSReqRecordDTO;
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
    private Colaborador osCol;

    @OneToMany(mappedBy = "com_os", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Comentario> listCom = new HashSet<>();

    public OS(OSReqRecordDTO data) {
        setDescricao(data.descricao());
        setAbertura(data.abertura());
        setEncerramento(data.encerramento());
        setOsCol(data.colaborador());
    }
}
