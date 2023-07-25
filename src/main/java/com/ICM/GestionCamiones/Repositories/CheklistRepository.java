package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.CamionesModel;
import com.ICM.GestionCamiones.Models.CheckListModel;
import com.ICM.GestionCamiones.Models.CheklistConductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheklistRepository extends JpaRepository<CheklistConductor, Long> {
    List<CheckListModel> findByCamionesModel(CamionesModel camionesModel);
}
