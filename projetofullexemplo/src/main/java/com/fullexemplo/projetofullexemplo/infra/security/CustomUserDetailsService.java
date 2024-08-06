package com.fullexemplo.projetofullexemplo.infra.security;

import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.repository.ColaboradorRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private ColaboradorRepository colaboradorRepository;

    public CustomUserDetailsService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Colaborador colaborador = this.colaboradorRepository
                .findByMatricula(username)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado!"));

        return new org.springframework.security.core.userdetails.User
                (colaborador.getMatricula(), colaborador.getPin(), new ArrayList<>());
    }
}
