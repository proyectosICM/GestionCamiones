package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.CheckListCarretaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListCarretaRepository extends JpaRepository<CheckListCarretaModel, Long> {
}
