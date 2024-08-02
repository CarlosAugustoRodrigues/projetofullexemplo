package com.fullexemplo.projetofullexemplo.dtos.comentario;

import java.time.LocalDate;
import java.util.UUID;

public record ComReqRecordDTO(
        LocalDate dataComentario,
        String comentario,
        UUID idColaborador,
        UUID idOs
        ) {
}
