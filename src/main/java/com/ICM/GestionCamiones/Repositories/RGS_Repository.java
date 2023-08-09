package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.RGSModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RGS_Repository extends JpaRepository<RGSModel, Long> {
    List<RGSModel> findByCheckListCamionModel_CamionesModel_EmpresasModel_IdAndCheckListCamionModel_CamionesModel_SedesModel_IdAndCheckListCamionModel_CamionesModel_Estado(Long empresaId, Long sedeId, Boolean estado);
}
