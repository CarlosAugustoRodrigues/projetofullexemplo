package com.fullexemplo.projetofullexemplo.services;

import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.Colaborador;
import com.fullexemplo.projetofullexemplo.repository.ColaboradorRepository;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ColService {

    ColaboradorRepository colRepository;

    public ColService(ColaboradorRepository colRepository) {
        this.colRepository = colRepository;
    }


    // READ
    public ResponseEntity<List<ColResRecordDTO>> read() {
        // Salvar todos os colaborador em uma lista
        List<ColResRecordDTO> listCol = colRepository
                                        .findAll()
                                        // Filtrar os dados do objeto da entidade Colaborador
                                        .stream()
                                        // Mapear cada objeto da entidade Colaborador para criar um novo ColResRecordDTO
                                        .map(ColResRecordDTO::new)
                                        // Transformar em lista
                                        .toList();

        // Retornar lista como resposta
        return ResponseEntity.status(HttpStatus.OK).body(listCol);
    }


    // READ BY ID
    // Receber id como parametro
    public ResponseEntity<Object> readById(UUID id) {
        // Encontrar colaborador pelo id (Optional, pois o colaborador pode não existir)
        Optional<Colaborador> col0 = colRepository.findById(id);

        // Se colaborador não existir retornar NOT_FOUND
        if (col0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado!");
        }

        // Se encontrou o colaborador, retornar os dados
        return ResponseEntity.status(HttpStatus.OK).body(col0.get());
    }


    // CREATE
    // Receber dados do objeto
    public ResponseEntity<Colaborador> create(ColReqRecordDTO data) {
        // Enviar dados recebido pelo corpo para o construtor da entidade Colaborador
        var newCol = new Colaborador(data);

        // Salvar dados
        colRepository.save(newCol);

        // Retornar resposta
        return ResponseEntity.status(HttpStatus.CREATED).body(newCol);
    }


    // UPDATE
    // Receber id e os dados do objeto modificados como parametro
    public ResponseEntity<Object> update(UUID id, ColReqRecordDTO data)  {
        // Encontrar colaborador pelo id (Optional, pois colaborador pode não existir)
        Optional<Colaborador> col0 = colRepository.findById(id);

        // Pegar os dados atuais do colaborador
        var colaborador = col0.get();

        // Se colaborador não existir, retornar NOT_FOUND
        if (col0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado!");
        }

        // Setar dados modificados nos campos
        colaborador.setNome(data.nome());
        colaborador.setCargo(data.cargo());
        colaborador.setSetor(data.setor());
        colaborador.setPin(data.pin());

        // Salvar alterações
        colRepository.save(colaborador);

        // Retornar resposta
        return ResponseEntity.status(HttpStatus.OK).body(colaborador);
    }


    // DELETE
    // Receber id como parametro
    public ResponseEntity<Object> delete(UUID id) {
        // Encontrar colaborador pelo id (Optional, pois colaborador pode não existir)
        Optional<Colaborador> col0 = colRepository.findById(id);

        // Se colaborador não existir, retornar NOT_FOUND
        if (col0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado!");
        }

        // Deletar objeto pelo id
        colRepository.delete(col0.get());

        // Retornar resposta
        return ResponseEntity.status(HttpStatus.OK).body("Colaborador excluído com sucesso!");

    }

}
