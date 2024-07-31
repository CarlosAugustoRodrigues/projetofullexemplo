package com.fullexemplo.projetofullexemplo.controllers;

import com.fullexemplo.projetofullexemplo.dtos.os.OSReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.os.OSResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.OS;
import com.fullexemplo.projetofullexemplo.services.OsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class OsControllers {

    OsService osService;

    public OsControllers(OsService osService) {
        this.osService = osService;
    }

    @GetMapping("/os")
    public ResponseEntity<List<OSResRecordDTO>> readAll() {
        return osService.read();
    }

    @GetMapping("/os/{id}")
    public ResponseEntity<Object> readById(@PathVariable(value = "id") UUID id) {
        return osService.readById(id);
    }

    @PostMapping("/os")
    public ResponseEntity<OS> create(@RequestBody @Validated OSReqRecordDTO data) {
        return osService.create(data);
    }

    @PutMapping("/os/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id,
                                         @RequestBody @Validated OSReqRecordDTO data) {

        return osService.update(id, data);
    }

    @DeleteMapping("/os/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {

        return osService.delete(id);
    }
}
