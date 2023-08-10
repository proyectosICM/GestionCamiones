package com.ICM.GestionCamiones.Repositories;

import com.ICM.GestionCamiones.Models.ObservacionesRGSModel;
import com.ICM.GestionCamiones.Models.RGSModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObservacionesRGSRepository extends JpaRepository<ObservacionesRGSModel, Long> {
    List<ObservacionesRGSModel> findByRgsModel(RGSModel rgsModel);
}
