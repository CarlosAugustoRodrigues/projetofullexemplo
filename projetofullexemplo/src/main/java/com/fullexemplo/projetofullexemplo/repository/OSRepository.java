package com.fullexemplo.projetofullexemplo.repository;

import com.fullexemplo.projetofullexemplo.entity.os.OS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OSRepository extends JpaRepository<OS, UUID> {
}
