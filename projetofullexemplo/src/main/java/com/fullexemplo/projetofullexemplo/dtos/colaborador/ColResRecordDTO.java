package com.fullexemplo.projetofullexemplo.dtos.colaborador;

import com.fullexemplo.projetofullexemplo.entity.Colaborador;

import java.util.UUID;

public record ColResRecordDTO(UUID id, String nome, String cargo, String setor, String pin) {

    public ColResRecordDTO(Colaborador data) {
        this(data.getId(), data.getNome(), data.getCargo(), data.getSetor(), data.getPin());
    }

}
