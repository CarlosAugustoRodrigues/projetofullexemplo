package com.fullexemplo.projetofullexemplo.repository;

import com.fullexemplo.projetofullexemplo.entity.colaborador.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
