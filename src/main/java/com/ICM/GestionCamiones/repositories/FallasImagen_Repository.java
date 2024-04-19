package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.FallasImagen_Model;
import com.ICM.GestionCamiones.models.RGSModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FallasImagen_Repository extends JpaRepository<FallasImagen_Model, Long> {

}