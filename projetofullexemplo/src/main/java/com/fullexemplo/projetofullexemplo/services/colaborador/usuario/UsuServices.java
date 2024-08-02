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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public ResponseEntity<List<UsuResRecordDTO>> readAll() {
        List<UsuResRecordDTO> listaUsu = usuarioRepository
                .findAll()
                .stream()
                .map(UsuResRecordDTO::new)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(listaUsu);
    }

        public ResponseEntity<Usuario> create(UsuReqRecordDTO data) {
        var dadosUsuario = new Usuario();

        dadosUsuario.setMatricula(data.matricula());
        dadosUsuario.setPin(data.pin());
        var colaborador = colaboradorRepository.findById(data.idColaborador()).get();
        dadosUsuario.setColaborador(colaborador);

        usuarioRepository.save(dadosUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(dadosUsuario);
    }

    public ResponseEntity<Object> update(UUID id, UsuReqRecordDTO data) {
        Optional<Usuario> usu0 = usuarioRepository.findById(id);

        if (usu0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DADOS DE USUARIO NÃO ENCONTRADO!");
        }

        var usuario = usu0.get();
        usuario.setMatricula(data.matricula());
        usuario.setPin(data.pin());

        usuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Usuario> usu0 = usuarioRepository.findById(id);

        if (usu0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DADOS DE USUARIO NÃO ENCONTRADO!");
        }

        usuarioRepository.delete(usu0.get());

        return ResponseEntity.status(HttpStatus.OK).body("DADOS DE USUARIO EXCLUIDO COM SUCESSO!");
    }
}
