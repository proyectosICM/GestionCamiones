package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.CamionesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamionesRepository extends JpaRepository<CamionesModel, Long> {
}
