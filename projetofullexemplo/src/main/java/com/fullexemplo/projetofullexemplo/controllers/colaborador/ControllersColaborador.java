package com.fullexemplo.projetofullexemplo.controllers.colaborador;

import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.services.colaborador.ColServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ControllersColaborador {


    ColServices colServices;

    public ControllersColaborador(ColServices colServices) {
        this.colServices = colServices;
    }

    @GetMapping("/colaborador")
    public ResponseEntity<List<ColResRecordDTO>> readAll() {
        return ResponseEntity.status(HttpStatus.OK).body(colServices.readAll());
    }

    @PostMapping("/colaborador")
    public ResponseEntity<Colaborador> create(@RequestBody @Validated ColReqRecordDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(colServices.create(data));
    }

    @PutMapping("/colaborador/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id")UUID id,
                                         @RequestBody @Validated ColReqRecordDTO data) {

        return ResponseEntity.status(HttpStatus.OK).body(colServices.update(id, data));
    }

    @DeleteMapping("/colaborador/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(colServices.delete(id));
    }
}
