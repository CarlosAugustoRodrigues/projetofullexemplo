package com.fullexemplo.projetofullexemplo.controllers.colaborador.usuario;

import com.fullexemplo.projetofullexemplo.dtos.colaborador.usuario.UsuReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.usuario.UsuResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.colaborador.usuario.Usuario;
import com.fullexemplo.projetofullexemplo.services.colaborador.usuario.UsuServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllersUsuario {

    UsuServices usuServices;

    public ControllersUsuario(UsuServices usuServices) {
        this.usuServices = usuServices;
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<UsuResRecordDTO>> readAll() {
        return ResponseEntity.status(HttpStatus.OK).body(usuServices.readAll());
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> create(@RequestBody @Validated UsuReqRecordDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuServices.create(data));
    }
}
