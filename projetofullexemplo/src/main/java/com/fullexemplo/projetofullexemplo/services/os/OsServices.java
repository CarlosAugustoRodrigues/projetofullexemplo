package com.fullexemplo.projetofullexemplo.services.os;

import com.fullexemplo.projetofullexemplo.dtos.os.OsReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.os.OsResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.os.OS;
import com.fullexemplo.projetofullexemplo.repository.ColaboradorRepository;
import com.fullexemplo.projetofullexemplo.repository.OSRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OsServices {

    OSRepository osRepository;
    ColaboradorRepository colaboradorRepository;

    public OsServices(OSRepository osRepository, ColaboradorRepository colaboradorRepository) {
        this.osRepository = osRepository;
        this.colaboradorRepository = colaboradorRepository;
    }

    public ResponseEntity<List<OsResRecordDTO>> readAll() {
        List<OsResRecordDTO> listaOs = osRepository
                .findAll()
                .stream()
                .map(OsResRecordDTO::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(listaOs);
    }

    public ResponseEntity<OS> create(OsReqRecordDTO data) {
        var os = new OS();

        os.setDescricao(data.descricao());
        os.setAbertura(data.abertura());
        os.setEncerramento(data.encerramento());
        os.setColaborador(colaboradorRepository.findById(data.idColaborador()).get());

        osRepository.save(os);

        return ResponseEntity.status(HttpStatus.CREATED).body(os);
    }

    public ResponseEntity<Object> update(UUID id, OsReqRecordDTO data) {
        Optional<OS> os0 = osRepository.findById(id);

        if (os0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ORDEM DE SERVIÇO NÃO ENCONTRADA!");
        }

        var os = os0.get();

        os.setDescricao(data.descricao());
        os.setAbertura(data.abertura());
        os.setEncerramento(data.encerramento());

        osRepository.save(os);

        return ResponseEntity.status(HttpStatus.OK).body(os);
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<OS> os0 = osRepository.findById(id);

        if (os0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ORDEM DE SERVIÇO NÃO ENCONTRADA!");
        }

        osRepository.delete(os0.get());

        return ResponseEntity.status(HttpStatus.OK).body("ORDEM DE SERVIÇO EXCLUIDA COM SUCESSO!");
    }
}
