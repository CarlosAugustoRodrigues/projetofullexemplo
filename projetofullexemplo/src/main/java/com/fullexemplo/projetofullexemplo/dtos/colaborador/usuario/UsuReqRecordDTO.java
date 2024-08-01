package com.fullexemplo.projetofullexemplo.dtos.colaborador.usuario;

import java.util.UUID;

public record UsuReqRecordDTO(
        String matricula,
        String pin,
        UUID idColaborador
) {
}
