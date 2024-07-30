package com.fullexemplo.projetofullexemplo.controllers;

import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.Colaborador;
import com.fullexemplo.projetofullexemplo.services.ColService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ColControllers {

    ColService colService;

    public ColControllers(ColService colService) {
        this.colService = colService;
    }

    @GetMapping("/test")
    public String test() {
        return "Funcionando";
    }

    @GetMapping("/colaborador")
    public ResponseEntity<List<ColResRecordDTO>> readAll() {
        return colService.read();
    }

    @GetMapping("/colaborador/{id}")
    public ResponseEntity<Object> readById(@PathVariable(value = "id")UUID id) {
        return colService.readById(id);
    }

    @PostMapping("/colaborador")
    public ResponseEntity<Colaborador> create(@RequestBody @Validated ColReqRecordDTO data) {
        return colService.create(data);
    }

    @PutMapping("/colaborador/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id,
                                         @RequestBody @Validated ColReqRecordDTO data) {

        return colService.update(id, data);
    }

    @DeleteMapping("/colaborador/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        return colService.delete(id);
    }

}
