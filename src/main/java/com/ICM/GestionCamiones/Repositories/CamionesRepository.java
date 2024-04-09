package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.CamionesModel;
import com.ICM.GestionCamiones.Models.EmpresasModel;
import com.ICM.GestionCamiones.Models.SedesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CamionesRepository extends JpaRepository<CamionesModel, Long> {
    List<CamionesModel> findByEmpresasModelAndEstado(EmpresasModel empresasModel, Boolean estado);
    List<CamionesModel> findByEmpresasModelAndSedesModelAndEstado(EmpresasModel empresasModel, SedesModel sedesModel, Boolean estado);
    Page<CamionesModel> findByEmpresasModelIdAndSedesModelIdAndEstado(Long empresasId, Long sedesId, Boolean estado, Pageable pageable);
    List<CamionesModel> findByEmpresasModelAndSedesModelAndEstadoAndEnreparacion(EmpresasModel empresasModel, SedesModel sedesModel, Boolean estado, Boolean Enreparacion);

}
