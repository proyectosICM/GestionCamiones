package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.CambioLlantasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CambioLlantasRepository extends JpaRepository<CambioLlantasModel, Long> {
}
