package com.fullexemplo.projetofullexemplo.dtos.os;

import java.time.LocalDate;
import java.util.UUID;

public record OsReqRecordDTO(
        String descricao,
        LocalDate abertura,
        LocalDate encerramento,
        UUID idColaboraodr
) {
}
