package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.RGSModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RGS_Repository extends JpaRepository<RGSModel, Long> {
}