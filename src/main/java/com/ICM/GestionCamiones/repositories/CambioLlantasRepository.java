package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.CambioLlantasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CambioLlantasRepository extends JpaRepository<CambioLlantasModel, Long> {
}
