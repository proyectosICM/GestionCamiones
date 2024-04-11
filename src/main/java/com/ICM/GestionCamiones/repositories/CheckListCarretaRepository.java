package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.CheckListCarretaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListCarretaRepository extends JpaRepository<CheckListCarretaModel, Long> {
}
