package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.CheckListExpresoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListExpresoRepository extends JpaRepository<CheckListExpresoModel, Long> {
}
