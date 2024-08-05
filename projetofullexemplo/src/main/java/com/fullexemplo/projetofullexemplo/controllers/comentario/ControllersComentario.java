package com.fullexemplo.projetofullexemplo.controllers.comentario;

import com.fullexemplo.projetofullexemplo.dtos.comentario.ComReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.comentario.ComResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.comentario.Comentario;
import com.fullexemplo.projetofullexemplo.services.comentario.ComServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ControllersComentario {

    ComServices comServices;

    public ControllersComentario(ComServices comServices) {
        this.comServices = comServices;
    }

    @GetMapping("/comentario")
    public ResponseEntity<List<ComResRecordDTO>> readAll() {
        return comServices.readAll();
    }

    @PostMapping("/comentario")
    public ResponseEntity<Comentario> create(@RequestBody @Validated ComReqRecordDTO data) {
        return comServices.create(data);
    }

    @PutMapping("/comentario/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id")UUID id,
                                         @RequestBody @Validated ComReqRecordDTO data) {

        return comServices.update(id, data);
    }

    @DeleteMapping("/comentario/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        return comServices.delete(id);
    }
}
