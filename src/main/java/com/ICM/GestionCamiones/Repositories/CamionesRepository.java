package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.CamionesModel;
import com.ICM.GestionCamiones.Models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CamionesRepository extends JpaRepository<CamionesModel, Long> {
    List<CamionesModel> findByEmpresasModelAndEstado(EmpresasModel empresasModel, Boolean estado);
}
