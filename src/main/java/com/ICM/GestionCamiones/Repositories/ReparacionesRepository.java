package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.ReparacionesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ReparacionesRepository extends JpaRepository<ReparacionesModel, Long> {
}
