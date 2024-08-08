package com.fullexemplo.projetofullexemplo.controllers.login;

import com.fullexemplo.projetofullexemplo.dtos.auth.AuthReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.auth.AuthResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.infra.security.TokenService;
import com.fullexemplo.projetofullexemplo.repository.ColaboradorRepository;
import com.fullexemplo.projetofullexemplo.services.login.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerLogin {

    private LoginService loginService;

    public ControllerLogin(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthReqRecordDTO data){
        return loginService.login(data);
    }
}
