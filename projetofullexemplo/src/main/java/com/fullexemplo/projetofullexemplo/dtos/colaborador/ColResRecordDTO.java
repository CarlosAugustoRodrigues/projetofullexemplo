package com.fullexemplo.projetofullexemplo.dtos.colaborador;

import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.entity.comentario.Comentario;
import com.fullexemplo.projetofullexemplo.entity.os.OS;

import java.util.Set;
import java.util.UUID;

public record ColResRecordDTO(
        UUID id,
        String nome,
        String cargo,
        String setor,
        String matricula,
        String pin,
        Set<OS> listaOs,
        Set<Comentario> ListaCom
) {

    public ColResRecordDTO(Colaborador data) {
        this(
                data.getId(),
                data.getNome(),
                data.getCargo(),
                data.getSetor(),
                data.getMatricula(),
                data.getPin(),
                data.getListaOs(),
                data.getListaCom()
                );
    }
}
