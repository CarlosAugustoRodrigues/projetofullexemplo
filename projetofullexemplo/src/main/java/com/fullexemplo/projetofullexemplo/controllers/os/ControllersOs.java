package com.fullexemplo.projetofullexemplo.controllers.os;

import com.fullexemplo.projetofullexemplo.dtos.os.OsReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.os.OsResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.os.OS;
import com.fullexemplo.projetofullexemplo.services.os.OsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ControllersOs {

    OsServices osServices;

    public ControllersOs(OsServices osServices) {
        this.osServices = osServices;
    }

    @GetMapping("/os")
    public ResponseEntity<List<OsResRecordDTO>> readAll() {
        return osServices.readAll();
    }

    @PostMapping("/os")
    public ResponseEntity<OS> create(@RequestBody @Validated OsReqRecordDTO data) {
        return osServices.create(data);
    }

    @PutMapping("/os/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id")UUID id,
                                         @RequestBody @Validated OsReqRecordDTO data) {
        return osServices.update(id, data);
    }

    @DeleteMapping("/os/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        return osServices.delete(id);
    }
}


