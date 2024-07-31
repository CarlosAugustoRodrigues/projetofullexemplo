package com.fullexemplo.projetofullexemplo.dtos.os;

import com.fullexemplo.projetofullexemplo.entity.Colaborador;

import java.time.LocalDate;

public record OSReqRecordDTO(
        String descricao,
        LocalDate abertura,
        LocalDate encerramento,
        Colaborador colaborador
) {
}
