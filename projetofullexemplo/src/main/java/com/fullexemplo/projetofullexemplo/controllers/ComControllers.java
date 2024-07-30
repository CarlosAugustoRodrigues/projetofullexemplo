package com.fullexemplo.projetofullexemplo.controllers;

import com.fullexemplo.projetofullexemplo.dtos.comentario.ComReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.comentario.ComResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.Comentario;
import com.fullexemplo.projetofullexemplo.services.ComService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ComControllers {

    ComService comService;

    public ComControllers(ComService comService) {
        this.comService = comService;
    }

    // READ ALL
    @GetMapping("/comentario")
    public ResponseEntity<List<ComResRecordDTO>> readAll() {
        return comService.read();
    }

    // READ BY ID
    @GetMapping("/comentario/{id}")
    public ResponseEntity<Object> readById(@PathVariable(value = "id")UUID id) {
        return comService.readById(id);
    }

    @PostMapping("/comentario")
    public ResponseEntity<Comentario> create(@RequestBody @Validated ComReqRecordDTO data) {
        return comService.create(data);
    }

    @PutMapping("/comentario/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id,
                                         @RequestBody @Validated ComReqRecordDTO data) {

        return comService.update(id, data);
    }

    @DeleteMapping("/comentario/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        return comService.delete(id);
    }


}
