package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.FallasImagen_Model;
import com.ICM.GestionCamiones.Models.RGSModel;
import com.ICM.GestionCamiones.Models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FallasImagen_Repository extends JpaRepository<FallasImagen_Model, Long> {
    List<FallasImagen_Model> findByRgsModel(RGSModel rgsModel);
}
