package com.fullexemplo.projetofullexemplo.repository;

import com.fullexemplo.projetofullexemplo.entity.comentario.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComentarioRepository extends JpaRepository<Comentario, UUID> {
}
