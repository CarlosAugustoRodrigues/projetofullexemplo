package com.fullexemplo.projetofullexemplo.services.colaborador;

import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.repository.ColaboradorRepository;
import com.fullexemplo.projetofullexemplo.repository.ComentarioRepository;
import com.fullexemplo.projetofullexemplo.repository.OSRepository;
import com.fullexemplo.projetofullexemplo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ColServices {


    ColaboradorRepository colaboradorRepository;
    UsuarioRepository usuarioRepository;
    ComentarioRepository comentarioRepository;
    OSRepository osRepository;

    public ColServices(
            ColaboradorRepository colaboradorRepository,
            UsuarioRepository usuarioRepository,
            ComentarioRepository comentarioRepository,
            OSRepository osRepository
    ) {
        this.colaboradorRepository = colaboradorRepository;
        this.usuarioRepository = usuarioRepository;
        this.comentarioRepository = comentarioRepository;
        this.osRepository = osRepository;
    }

    public List<ColResRecordDTO> readAll() {
        List<ColResRecordDTO> listaCol = colaboradorRepository
                .findAll()
                .stream()
                .map(ColResRecordDTO::new)
                .toList();

        return listaCol;
    }

    public Colaborador create(ColReqRecordDTO data) {
        var colaborador = new Colaborador(data);

        colaboradorRepository.save(colaborador);

        return colaborador;
    }

    public Object update(UUID id, ColReqRecordDTO data) {
        var col0 = colaboradorRepository.findById(id);

        if (col0.isEmpty()) {
            return "COLABORADOR NÃO ENCONTRADO!";
        }

        var colaborador = col0.get();

        colaborador.setNome(data.nome());
        colaborador.setCargo(data.cargo());
        colaborador.setSetor(data.setor());

        colaboradorRepository.save(colaborador);

        return colaborador;
    }

    public Object delete(UUID id) {
       var col0 = colaboradorRepository.findById(id);

       if (col0.isEmpty()) {
           return "COLABORADOR NÃO ENCONTRADO!";
       }

       colaboradorRepository.delete(col0.get());

       return "COLABORADOR EXCLUÍDO COM SUCESSO!";
    }
}
