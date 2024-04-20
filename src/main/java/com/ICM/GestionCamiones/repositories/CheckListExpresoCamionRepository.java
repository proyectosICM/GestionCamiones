package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.CamionesModel;
import com.ICM.GestionCamiones.models.CheckListCarretaModel;
import com.ICM.GestionCamiones.models.ChecklistExpresoCamionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckListExpresoCamionRepository extends JpaRepository<ChecklistExpresoCamionModel, Long> {
    Page<ChecklistExpresoCamionModel> findByCamionesModelId(Long camionesId, Pageable pageable);
    List<ChecklistExpresoCamionModel> findByCamionesModel(CamionesModel camionesModel);
    List<ChecklistExpresoCamionModel> findByCamionesModelEmpresasModelId(Long id);
}
