package com.fullexemplo.projetofullexemplo.services;

import com.fullexemplo.projetofullexemplo.dtos.os.OSReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.os.OSResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.OS;
import com.fullexemplo.projetofullexemplo.repository.OSRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class OsService {

    OSRepository osRepository;

    public OsService(OSRepository osRepository) {
        this.osRepository = osRepository;
    }

    public ResponseEntity<List<OSResRecordDTO>> read() {
        List<OSResRecordDTO> osList = osRepository.findAll()
                                    .stream()
                                    .map(OSResRecordDTO::new)
                                    .toList();

        return ResponseEntity.status(HttpStatus.OK).body(osList);
    }

    public ResponseEntity<Object> readById(UUID id) {
        Optional<OS> os0 = osRepository.findById(id);


        if (os0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS não encontrada!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(os0.get());
    }

    public ResponseEntity<OS> create(OSReqRecordDTO data) {
        var newOs = new OS(data);

        osRepository.save(newOs);

        return ResponseEntity.status(HttpStatus.CREATED).body(newOs);
    }

    public ResponseEntity<Object> update(UUID id, OSReqRecordDTO data) {
        Optional<OS> os0 = osRepository.findById(id);

        if (os0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS não encontrada!");
        }

        var os = os0.get();

        os.setDescricao(data.descricao());
        os.setAbertura(data.abertura());
        os.setEncerramento(data.encerramento());
        os.setOs_col(data.colaborador());

        osRepository.save(os);

        return ResponseEntity.status(HttpStatus.OK).body(os);
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<OS> os0 = osRepository.findById(id);

        if (os0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS não encontrada!");
        }

        osRepository.delete(os0.get());

        return ResponseEntity.status(HttpStatus.OK).body("OS excluída com sucesso!");
    }

}
