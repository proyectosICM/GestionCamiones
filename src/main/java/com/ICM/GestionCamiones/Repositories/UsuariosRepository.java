package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<UsuariosModel, Long> {
}
