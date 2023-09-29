package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.RGSModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RGS_Repository extends JpaRepository<RGSModel, Long> {
    List<RGSModel> findByCheckListCamionModel_CamionesModel_EmpresasModel_IdAndCheckListCamionModel_CamionesModel_SedesModel_IdAndCheckListCamionModel_CamionesModel_Estado(Long empresaId, Long sedeId, Boolean estado);
    @Query("SELECT r FROM RGSModel r " +
            "WHERE (r.checkListCamionModel.camionesModel.empresasModel.id = :empresaId " +
            "AND r.checkListCamionModel.camionesModel.sedesModel.id = :sedeId) " +
            "OR (r.checkListCarretaModel.camionesModel.empresasModel.id = :empresaId " +
            "AND r.checkListCarretaModel.camionesModel.sedesModel.id = :sedeId " +
            "AND r.estado = :estado " +
            "AND r.reparacion = :reparacion)")
    List<RGSModel> findByCriteria2(Long empresaId, Long sedeId, Boolean estado, Boolean reparacion);

    @Query("SELECT r FROM RGSModel r " +
            "WHERE (r.checkListCamionModel.camionesModel.empresasModel.id = :empresaId " +
            "AND r.checkListCamionModel.camionesModel.sedesModel.id = :sedeId) " +
            "OR (r.checkListCarretaModel.camionesModel.empresasModel.id = :empresaId " +
            "AND r.checkListCarretaModel.camionesModel.sedesModel.id = :sedeId " +
            "AND r.estado = :estado " +
            "AND r.reparacion = :reparacion)")
    List<RGSModel> findByCriteria(Long empresaId, Long sedeId, Boolean estado, Boolean reparacion);
}