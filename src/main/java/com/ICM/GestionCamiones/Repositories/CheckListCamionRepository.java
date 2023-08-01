package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.CamionesModel;
import com.ICM.GestionCamiones.Models.CheckListCamionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckListCamionRepository extends JpaRepository<CheckListCamionModel, Long> {
    List<CheckListCamionModel> findByCamionesModel(CamionesModel camionesModel);
}
