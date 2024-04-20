package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.CamionesModel;
import com.ICM.GestionCamiones.models.CheckListCarretaModel;
import com.ICM.GestionCamiones.models.ChecklistExpresoCamionModel;
import com.ICM.GestionCamiones.models.ChecklistExpresoCarretaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklistExpresoCarretaRepository extends JpaRepository<ChecklistExpresoCarretaModel, Long> {
    Page<ChecklistExpresoCarretaModel> findByCamionesModelId(Long camionesId, Pageable pageable);
    List<ChecklistExpresoCarretaModel> findByCamionesModel(CamionesModel camionesModel);
    List<ChecklistExpresoCarretaModel> findByCamionesModelEmpresasModelId(Long id);

}
