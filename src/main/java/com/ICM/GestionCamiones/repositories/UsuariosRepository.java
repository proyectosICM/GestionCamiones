package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<UsuariosModel, Long> {
    Optional<UsuariosModel> findByUsername(String username);
}
