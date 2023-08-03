package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.RGS_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RGS_Repository extends JpaRepository<RGS_Model, Long> {
}
