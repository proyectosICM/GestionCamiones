package com.ICM.GestionCamiones.repositories;

import com.ICM.GestionCamiones.models.ObservacionesRGSModel;
import com.ICM.GestionCamiones.models.RGSModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObservacionesRGSRepository extends JpaRepository<ObservacionesRGSModel, Long> {
    List<ObservacionesRGSModel> findByRgsModel(RGSModel rgsModel);
}
