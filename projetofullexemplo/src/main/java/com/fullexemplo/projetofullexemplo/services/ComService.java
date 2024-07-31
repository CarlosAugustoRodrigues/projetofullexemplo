package com.fullexemplo.projetofullexemplo.services;

import com.fullexemplo.projetofullexemplo.dtos.comentario.ComReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.comentario.ComResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.Comentario;
import com.fullexemplo.projetofullexemplo.repository.ComentarioRepository;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComService {

    ComentarioRepository comRepository;

    public ComService(ComentarioRepository comRepository) {
        this.comRepository = comRepository;
    }


    // READ ALL
    public ResponseEntity<List<ComResRecordDTO>> read() {
        List<ComResRecordDTO> listCom = comRepository.findAll()
                                        .stream()
                                        .map(ComResRecordDTO::new)
                                        .toList();

        return ResponseEntity.status(HttpStatus.OK).body(listCom);
    }


    // READ BY ID
    public ResponseEntity<Object> readById(UUID id) {
        Optional<Comentario> com0 = comRepository.findById(id);

        if (com0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comentario não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(com0.get());
    }


    // CREATE
    public ResponseEntity<Comentario> create(ComReqRecordDTO data) {
        var newCom = new Comentario(data);

        comRepository.save(newCom);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCom);
    }


    // UPDATE
    public ResponseEntity<Object> update(UUID id, ComReqRecordDTO data) {
        Optional<Comentario> com0 = comRepository.findById(id);
        var com = com0.get();

        if (com0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comentario não encontrado!");
        }

        com.setData_comentario(data.dataComentario());
        com.setComentario(data.comentario());
        com.setCom_os(data.os());
        com.setCom_col(data.colaborador());

        comRepository.save(com);

        return ResponseEntity.status(HttpStatus.OK).body(com);
    }


    // DELETE
    public ResponseEntity<Object> delete(UUID id) {
        Optional<Comentario> com0 = comRepository.findById(id);

        if (com0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comentario não encontrado!");
        }

        comRepository.delete(com0.get());

        return ResponseEntity.status(HttpStatus.OK).body("Comentario excluído com sucesso!");
    }

}
