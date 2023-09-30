package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.RGSModel;
import com.ICM.GestionCamiones.Models.ReparacionesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ReparacionesRepository extends JpaRepository<ReparacionesModel, Long> {

    List<ReparacionesModel> findByRgsModel(RGSModel rgsModel);
}
