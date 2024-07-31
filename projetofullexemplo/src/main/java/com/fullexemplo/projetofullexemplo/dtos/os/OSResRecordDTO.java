package com.fullexemplo.projetofullexemplo.dtos.os;

import com.fullexemplo.projetofullexemplo.entity.Colaborador;
import com.fullexemplo.projetofullexemplo.entity.Comentario;
import com.fullexemplo.projetofullexemplo.entity.OS;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record OSResRecordDTO(
        UUID id,
        String descricao,
        LocalDate abertura,
        LocalDate encerramento,
        Colaborador colaborador,
        Set<Comentario> listCom
) {

    public OSResRecordDTO(OS data) {
        this(
                data.getId(),
                data.getDescricao(),
                data.getAbertura(),
                data.getEncerramento(),
                data.getOsCol(),
                data.getListCom()
        );
    }

}
