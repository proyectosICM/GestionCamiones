package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.CamionesModel;
import com.ICM.GestionCamiones.models.CheckListCamionModel;
import com.ICM.GestionCamiones.models.CheckListCarretaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckListCarretaRepository extends JpaRepository<CheckListCarretaModel, Long> {
    List<CheckListCarretaModel> findByCamionesModel(CamionesModel camionesModel);
    List<CheckListCarretaModel> findByCamionesModelEmpresasModelId(Long id);
}
