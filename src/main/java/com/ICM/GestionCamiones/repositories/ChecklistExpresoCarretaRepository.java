package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.ChecklistExpresoCamionModel;
import com.ICM.GestionCamiones.models.ChecklistExpresoCarretaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistExpresoCarretaRepository extends JpaRepository<ChecklistExpresoCarretaModel, Long> {
    Page<ChecklistExpresoCarretaModel> findByCamionesModelId(Long camionesId, Pageable pageable);
}
