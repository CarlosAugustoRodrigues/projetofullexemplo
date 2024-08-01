package com.fullexemplo.projetofullexemplo.dtos.os;

import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.entity.comentario.Comentario;
import com.fullexemplo.projetofullexemplo.entity.os.OS;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record OsResRecordDTO(
        UUID id,
        String descricao,
        LocalDate abertura,
        LocalDate encerramento,
        Colaborador colaborador,
        Set<Comentario> listaCom
) {

    public OsResRecordDTO(OS data) {
        this(
                data.getId(),
                data.getDescricao(),
                data.getAbertura(),
                data.getEncerramento(),
                data.getColaborador(),
                data.getListaCom()
        );
    }
}
