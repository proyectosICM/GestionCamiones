package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.CheckListExpresoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListExpresoRepository extends JpaRepository<CheckListExpresoModel, Long> {
}
