package com.fullexemplo.projetofullexemplo.repository;

import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ColaboradorRepository extends JpaRepository<Colaborador, UUID> {
    Optional<Colaborador> findByMatricula(String matricula);
}
