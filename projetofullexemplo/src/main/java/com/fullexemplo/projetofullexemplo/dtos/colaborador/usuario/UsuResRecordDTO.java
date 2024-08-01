package com.fullexemplo.projetofullexemplo.dtos.colaborador.usuario;

import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.entity.colaborador.usuario.Usuario;

import java.util.UUID;

public record UsuResRecordDTO(
        UUID id,
        String matricula,
        String pin,
        Colaborador colaborador
) {

    public UsuResRecordDTO(Usuario data) {
        this(
                data.getId(),
                data.getMatricula(),
                data.getPin(),
                data.getColaborador()
        );
    }
}
