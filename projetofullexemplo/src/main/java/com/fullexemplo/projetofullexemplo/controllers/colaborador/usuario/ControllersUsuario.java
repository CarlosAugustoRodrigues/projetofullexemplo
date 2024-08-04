package com.fullexemplo.projetofullexemplo.controllers.colaborador.usuario;

import com.fullexemplo.projetofullexemplo.dtos.colaborador.usuario.UsuReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.usuario.UsuResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.colaborador.usuario.Usuario;
import com.fullexemplo.projetofullexemplo.services.colaborador.usuario.UsuServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ControllersUsuario {

    UsuServices usuServices;

    public ControllersUsuario(UsuServices usuServices) {
        this.usuServices = usuServices;
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<UsuResRecordDTO>> readAll() {
        return usuServices.readAll();
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> create(@RequestBody @Validated UsuReqRecordDTO data) {
        return usuServices.create(data);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id")UUID id,
                                         @RequestBody @Validated UsuReqRecordDTO data) {

        return usuServices.update(id, data);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        return usuServices.delete(id);
    }
}
