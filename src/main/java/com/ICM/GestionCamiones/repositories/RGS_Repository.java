package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.RGSModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RGS_Repository extends JpaRepository<RGSModel, Long> {
    Optional<RGSModel> findByUsuariosModelIdAndEnUso(Long usuarioId, Boolean enUso);
}