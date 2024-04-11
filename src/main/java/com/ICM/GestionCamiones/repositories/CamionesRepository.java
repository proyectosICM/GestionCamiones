package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.CamionesModel;
import com.ICM.GestionCamiones.models.EmpresasModel;
import com.ICM.GestionCamiones.models.SedesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CamionesRepository extends JpaRepository<CamionesModel, Long> {
    Optional<CamionesModel> findByPlaca(String placa);
    List<CamionesModel> findByEmpresasModelAndEstado(EmpresasModel empresasModel, Boolean estado);
    List<CamionesModel> findByEmpresasModelAndSedesModelAndEstado(EmpresasModel empresasModel, SedesModel sedesModel, Boolean estado);
    Page<CamionesModel> findByEmpresasModelIdAndSedesModelIdAndEstado(Long empresasId, Long sedesId, Boolean estado, Pageable pageable);
    List<CamionesModel> findByEmpresasModelAndSedesModelAndEstadoAndEnreparacion(EmpresasModel empresasModel, SedesModel sedesModel, Boolean estado, Boolean Enreparacion);

}
