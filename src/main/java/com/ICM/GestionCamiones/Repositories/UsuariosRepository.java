package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<UsuariosModel, Long> {
    Optional<UsuariosModel> findByUsername(String username);
}
