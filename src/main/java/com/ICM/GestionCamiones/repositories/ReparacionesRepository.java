package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.RGSModel;
import com.ICM.GestionCamiones.models.ReparacionesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReparacionesRepository extends JpaRepository<ReparacionesModel, Long> {

    List<ReparacionesModel> findByRgsModel(RGSModel rgsModel);
}
