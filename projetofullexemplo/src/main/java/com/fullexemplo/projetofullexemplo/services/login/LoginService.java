package com.fullexemplo.projetofullexemplo.services.login;

import com.fullexemplo.projetofullexemplo.dtos.auth.AuthReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.auth.AuthResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.infra.security.TokenService;
import com.fullexemplo.projetofullexemplo.repository.ColaboradorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class LoginService {

    private final ColaboradorRepository colaboradorRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public LoginService(ColaboradorRepository colaboradorRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.colaboradorRepository = colaboradorRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public ResponseEntity login(AuthReqRecordDTO data){
        Optional<Colaborador> colaborador0 = colaboradorRepository.findByMatricula(data.matricula());
        if (colaborador0.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("COLABORADOR NÃO ENCONTRADO!");
        }
        var colaborador = colaborador0.get();

        if(passwordEncoder.matches(data.pin(), colaborador.getPin())) {
            String token = tokenService.generateToken(colaborador);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new AuthResRecordDTO(colaborador.getNome(), token));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO AUTENTICAR! MATRICULA OU SENHA ERRADAS!");
    }

}
