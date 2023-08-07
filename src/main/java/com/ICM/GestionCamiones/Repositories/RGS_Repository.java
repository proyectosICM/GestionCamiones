package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.CheckListCamionModel;
import com.ICM.GestionCamiones.Models.EmpresasModel;
import com.ICM.GestionCamiones.Models.RGS_Model;
import com.ICM.GestionCamiones.Models.SedesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RGS_Repository extends JpaRepository<RGS_Model, Long> {
    List<RGS_Model> findByCheckListCamionModel_CamionesModel_EmpresasModel_IdAndCheckListCamionModel_CamionesModel_SedesModel_IdAndCheckListCamionModel_CamionesModel_Estado(Long empresaId, Long sedeId, Boolean estado);
}
