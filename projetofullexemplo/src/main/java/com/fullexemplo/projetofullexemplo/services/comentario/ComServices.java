package com.fullexemplo.projetofullexemplo.services.comentario;


import com.fullexemplo.projetofullexemplo.dtos.comentario.ComReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.comentario.ComResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.comentario.Comentario;
import com.fullexemplo.projetofullexemplo.repository.ColaboradorRepository;
import com.fullexemplo.projetofullexemplo.repository.ComentarioRepository;
import com.fullexemplo.projetofullexemplo.repository.OSRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComServices {

    OSRepository osRepository;
    ComentarioRepository comentarioRepository;
    ColaboradorRepository colaboradorRepository;

    public ComServices(OSRepository osRepository, ComentarioRepository comentarioRepository, ColaboradorRepository colaboradorRepository) {
        this.osRepository = osRepository;
        this.comentarioRepository = comentarioRepository;
        this.colaboradorRepository = colaboradorRepository;
    }

    public ResponseEntity<List<ComResRecordDTO>> readAll() {
        List<ComResRecordDTO> listaComentario = comentarioRepository
                .findAll()
                .stream()
                .map(ComResRecordDTO::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(listaComentario);
    }

    public ResponseEntity<Comentario> create(ComReqRecordDTO data) {
        var com = new Comentario();

        com.setDataComentario(data.dataComentario());
        com.setComentario(data.comentario());
        com.setColaborador(colaboradorRepository.findById(data.idColaborador()).get());
        com.setOs(osRepository.findById(data.idOs()).get());

        comentarioRepository.save(com);

        return ResponseEntity.status(HttpStatus.CREATED).body(com);
    }

    public ResponseEntity<Object> update(UUID id, ComReqRecordDTO data) {
        Optional<Comentario> com0 = comentarioRepository.findById(id);

        if (com0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("COMENTARIO NÃO ENCONTRADO!");
        }

        var com = com0.get();
        com.setDataComentario(data.dataComentario());
        com.setComentario(data.comentario());

        comentarioRepository.save(com);

        return ResponseEntity.status(HttpStatus.OK).body(com);
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Comentario> com0 = comentarioRepository.findById(id);

        if (com0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("COMENTARIO NÃO ENCONTRADO!");
        }

        comentarioRepository.delete(com0.get());

        return ResponseEntity.status(HttpStatus.OK).body("COMENTARIO EXCLUIDO COM SUCESSO!");
    }
}
