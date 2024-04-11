package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.CamionesModel;
import com.ICM.GestionCamiones.models.CheckListCamionModel;
import com.ICM.GestionCamiones.models.CheklistConductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheklistRepository extends JpaRepository<CheklistConductor, Long> {
    List<CheckListCamionModel> findByCamionesModel(CamionesModel camionesModel);
}
