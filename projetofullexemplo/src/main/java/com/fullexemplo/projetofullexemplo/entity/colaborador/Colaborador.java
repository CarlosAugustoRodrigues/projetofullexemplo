package com.fullexemplo.projetofullexemplo.entity.colaborador;

import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.usuario.UsuReqRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.colaborador.usuario.Usuario;
import com.fullexemplo.projetofullexemplo.entity.comentario.Comentario;
import com.fullexemplo.projetofullexemplo.entity.os.OS;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "colaborador", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OS> listaOs = new HashSet<>();

    @OneToMany(mappedBy = "colaborador", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Comentario> listaCom = new HashSet<>();

    public Colaborador(ColReqRecordDTO data) {
        setNome(data.nome());
        setCargo(data.cargo());
        setSetor(data.setor());
    }
}
