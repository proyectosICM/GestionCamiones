package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.FallasImagen_Model;
import com.ICM.GestionCamiones.models.RGSModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FallasImagen_Repository extends JpaRepository<FallasImagen_Model, Long> {
    List<FallasImagen_Model> findByEmpresaModelIdAndCheckListCamionModelIdOrCheckListCarretaModelId(Long empresaId, Long checkListCamionModelId, Long checkListCarretaModelId);
    List<FallasImagen_Model> findByEmpresaModelIdAndChecklistExpresoCamionModelIdOrChecklistExpresoCarretaModelId(Long empresaId, Long checklistExpresoCamionModelId, Long checkListExpresoCarretaModelId);
    List<FallasImagen_Model> findByEmpresaModelIdAndChecklistExpresoCamionModelId(Long empresaId, Long checklistExpresoCamionModelId);
    List<FallasImagen_Model> findByEmpresaModelIdAndChecklistExpresoCarretaModelId(Long empresaId, Long checkListExpresoCarretaModelId);

    List<FallasImagen_Model> findByCheckListCamionModelId(Long clc);
}
