package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.FallasImagen_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FallasImagen_Repository extends JpaRepository<FallasImagen_Model, Long> {
}
