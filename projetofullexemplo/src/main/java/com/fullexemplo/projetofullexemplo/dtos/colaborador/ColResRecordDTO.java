package com.fullexemplo.projetofullexemplo.dtos.colaborador;

import com.fullexemplo.projetofullexemplo.entity.Colaborador;
import com.fullexemplo.projetofullexemplo.entity.Comentario;
import com.fullexemplo.projetofullexemplo.entity.OS;

import java.util.Set;
import java.util.UUID;

public record ColResRecordDTO(
        UUID id,
        String nome,
        String cargo,
        String setor,
        String pin,
        Set<OS> listOs,
        Set<Comentario> listCom
) {

    public ColResRecordDTO(Colaborador data) {
        this(
                data.getId(),
                data.getNome(),
                data.getCargo(),
                data.getSetor(),
                data.getPin(),
                data.getListOs(),
                data.getListCom()
        );
    }

}
