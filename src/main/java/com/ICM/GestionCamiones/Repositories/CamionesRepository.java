package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.CamionesModel;
import com.ICM.GestionCamiones.Models.EmpresasModel;
import com.ICM.GestionCamiones.Models.SedesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CamionesRepository extends JpaRepository<CamionesModel, Long> {
    List<CamionesModel> findByEmpresasModelAndEstado(EmpresasModel empresasModel, Boolean estado);
    List<CamionesModel> findByEmpresasModelAndSedesModelAndEstado(EmpresasModel empresasModel, SedesModel sedesModel, Boolean estado);
    List<CamionesModel> findByEmpresasModelAndSedesModelAndEstadoAndEnreparacion(EmpresasModel empresasModel, SedesModel sedesModel, Boolean estado, Boolean Enreparacion);

}
