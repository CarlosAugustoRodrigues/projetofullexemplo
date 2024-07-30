package com.fullexemplo.projetofullexemplo.dtos.comentario;

import com.fullexemplo.projetofullexemplo.entity.Colaborador;
import com.fullexemplo.projetofullexemplo.entity.Comentario;
import com.fullexemplo.projetofullexemplo.entity.OS;

import java.time.LocalDate;
import java.util.UUID;

public record ComResRecordDTO(UUID id,
                              LocalDate data_comentario,
                              String comentario,
                              OS os,
                              Colaborador colaborador) {

    public ComResRecordDTO(Comentario data) {
        this(data.getId(), data.getData_comentario(), data.getComentario(), data.getOs(), data.getColaborador());
    }
}
