package com.fullexemplo.projetofullexemplo.entity;

import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColReqRecordDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
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

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String setor;

    @Column(nullable = false, unique = true)
    private String pin;

    @OneToMany(mappedBy = "os_col", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OS> listOs = new HashSet<>();


    @OneToMany(mappedBy = "com_col", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Comentario> listCom = new HashSet<>();

    public Colaborador(ColReqRecordDTO data) {
        setNome(data.nome());
        setCargo(data.cargo());
        setSetor(data.setor());
        setPin(data.pin());
    }

}
