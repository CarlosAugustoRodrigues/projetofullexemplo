package com.fullexemplo.projetofullexemplo.repository;

import com.fullexemplo.projetofullexemplo.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ColaboradorRepository extends JpaRepository<Colaborador, UUID> {
}
