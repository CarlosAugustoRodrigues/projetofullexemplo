package com.fullexemplo.projetofullexemplo.services.colaborador;

import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.repository.ColaboradorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ColServices {


    ColaboradorRepository colaboradorRepository;
    PasswordEncoder passwordEncoder;

    public ColServices(ColaboradorRepository colaboradorRepository, PasswordEncoder passwordEncoder) {
        this.colaboradorRepository = colaboradorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // READ ALL
    public ResponseEntity<List<ColResRecordDTO>> readAll() {
        List<ColResRecordDTO> listaCol = colaboradorRepository
                .findAll()
                .stream()
                .map(ColResRecordDTO::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(listaCol);
    }


    // READ BY MATRICULA
    public ResponseEntity<Object> readByMatricula(String matricula) {
        Optional<Colaborador> col0 = colaboradorRepository.findByMatricula(matricula);

        if (col0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("COLABORADOR NÃO ENCONTRADO!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(col0.get());
    }


    // CREATE
    public ResponseEntity<Object> create(ColReqRecordDTO data) {
        Optional<Colaborador> col0 = colaboradorRepository.findByMatricula(data.matricula());

        if (col0.isEmpty()) {
            var colaborador = new Colaborador(data);
            colaborador.setPin(passwordEncoder.encode(data.pin()));

            colaboradorRepository.save(colaborador);
            return ResponseEntity.status(HttpStatus.CREATED).body(colaborador);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("COLABORADOR COM MATRIUCLA: " + data.matricula() + " JÁ EXISTENTE!");
    }


    // UPDATE
    public ResponseEntity<Object> update(UUID id, ColReqRecordDTO data) {
        Optional<Colaborador> col0 = colaboradorRepository.findById(id);

        if (col0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("COLABORADOR NÃO ENCONTRADO!");
        }

        var colaborador = col0.get();

        colaborador.setNome(data.nome());
        colaborador.setCargo(data.cargo());
        colaborador.setSetor(data.setor());

        colaboradorRepository.save(colaborador);

        return ResponseEntity.status(HttpStatus.OK).body(colaborador);
    }


    // DELETE
    public ResponseEntity<Object> delete(UUID id) {
       Optional<Colaborador> col0 = colaboradorRepository.findById(id);

       if (col0.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("COLABORADOR NÃO ENCONTRADO!");
       }

       colaboradorRepository.delete(col0.get());

       return ResponseEntity.status(HttpStatus.OK).body("COLABORADOR EXCLUIDO COM SUCESSO!");
    }
}
