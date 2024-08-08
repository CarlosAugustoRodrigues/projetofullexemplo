package com.fullexemplo.projetofullexemplo.controllers.colaborador;

import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColResRecordDTO;
import com.fullexemplo.projetofullexemplo.services.colaborador.ColServices;
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
        return colServices.readAll();
    }

    @GetMapping("/colaborador/{matricula}")
    public ResponseEntity<Object> readByMatricula(@PathVariable(value = "matricula") String matricula) {
        return colServices.readByMatricula(matricula);
    }

    @PostMapping("/colaborador")
    public ResponseEntity<Object> create(@RequestBody @Validated ColReqRecordDTO data) {
        return colServices.create(data);
    }

    @PutMapping("/colaborador/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id")UUID id,
                                         @RequestBody @Validated ColReqRecordDTO data) {

        return colServices.update(id, data);
    }

    @DeleteMapping("/colaborador/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        return colServices.delete(id);
    }
}
