package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.CamionesModel;
import com.ICM.GestionCamiones.models.CheckListCamionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckListCamionRepository extends JpaRepository<CheckListCamionModel, Long> {
    List<CheckListCamionModel> findByCamionesModel(CamionesModel camionesModel);
}
