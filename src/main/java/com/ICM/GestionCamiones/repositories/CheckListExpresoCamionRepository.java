package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.ChecklistExpresoCamionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListExpresoCamionRepository extends JpaRepository<ChecklistExpresoCamionModel, Long> {
    Page<ChecklistExpresoCamionModel> findByCamionesModelId(Long camionesId, Pageable pageable);
}
