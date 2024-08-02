package com.fullexemplo.projetofullexemplo.dtos.comentario;

import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.entity.comentario.Comentario;
import com.fullexemplo.projetofullexemplo.entity.os.OS;

import java.time.LocalDate;
import java.util.UUID;

public record ComResRecordDTO(
        UUID id,
        LocalDate dataComentario,
        String comentario,
        Colaborador colaborador,
        OS os
) {

    public ComResRecordDTO(Comentario data) {
        this(
                data.getId(),
                data.getDataComentario(),
                data.getComentario(),
                data.getColaborador(),
                data.getOs()
        );
    }
}
