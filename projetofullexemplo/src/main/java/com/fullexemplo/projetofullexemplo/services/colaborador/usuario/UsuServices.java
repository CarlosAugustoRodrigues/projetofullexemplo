package com.fullexemplo.projetofullexemplo.services.colaborador.usuario;

import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColResRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.usuario.UsuReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.usuario.UsuResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.entity.colaborador.usuario.Usuario;
import com.fullexemplo.projetofullexemplo.repository.ColaboradorRepository;
import com.fullexemplo.projetofullexemplo.repository.ComentarioRepository;
import com.fullexemplo.projetofullexemplo.repository.OSRepository;
import com.fullexemplo.projetofullexemplo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuServices {

    ColaboradorRepository colaboradorRepository;
    UsuarioRepository usuarioRepository;
    ComentarioRepository comentarioRepository;
    OSRepository osRepository;

    public UsuServices(
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

    public List<UsuResRecordDTO> readAll() {
        List<UsuResRecordDTO> listaCol = usuarioRepository
                .findAll()
                .stream()
                .map(UsuResRecordDTO::new)
                .toList();
        return listaCol;
    }

    public Usuario create(UsuReqRecordDTO data) {
        var dadosUsuario = new Usuario();

        dadosUsuario.setMatricula(data.matricula());
        dadosUsuario.setPin(data.pin());
        dadosUsuario.setColaborador(colaboradorRepository.findById(data.idColaborador()).get());

        usuarioRepository.save(dadosUsuario);

        return dadosUsuario;
    }

    public Object update(UUID id, ColReqRecordDTO data) {
        var col0 = colaboradorRepository.findById(id);

        if (col0.isEmpty()) {
            return null;
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
            return "NOT_FOUND!";
        }

        colaboradorRepository.delete(col0.get());

        return "COLABORADOR DELETED!";
    }
}
