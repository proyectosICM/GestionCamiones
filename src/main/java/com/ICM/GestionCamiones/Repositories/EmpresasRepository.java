package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresasRepository extends JpaRepository<EmpresasModel, Long> {
}
