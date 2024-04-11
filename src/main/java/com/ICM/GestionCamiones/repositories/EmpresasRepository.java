package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresasRepository extends JpaRepository<EmpresasModel, Long> {
}
