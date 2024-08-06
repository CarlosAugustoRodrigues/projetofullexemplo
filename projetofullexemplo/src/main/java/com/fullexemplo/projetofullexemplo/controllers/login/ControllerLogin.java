package com.fullexemplo.projetofullexemplo.controllers.login;

import com.fullexemplo.projetofullexemplo.dtos.auth.AuthReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.auth.AuthResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.infra.security.TokenService;
import com.fullexemplo.projetofullexemplo.repository.ColaboradorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerLogin {

    private final ColaboradorRepository colaboradorRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public ControllerLogin(ColaboradorRepository colaboradorRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.colaboradorRepository = colaboradorRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthReqRecordDTO body){
        Colaborador colaborador = this.colaboradorRepository.findByMatricula(body.matricula())
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado!"));

        boolean result = body.pin() instanceof String;
        boolean result2 = colaborador.getPin() instanceof String;
        if(passwordEncoder.matches(body.pin(), colaborador.getPin())) {
            String token = this.tokenService.generateToken(colaborador);
            return ResponseEntity.ok(new AuthResRecordDTO(colaborador.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
