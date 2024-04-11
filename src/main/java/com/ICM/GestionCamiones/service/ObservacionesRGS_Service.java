package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.ObservacionesRGSModel;
import com.ICM.GestionCamiones.models.RGSModel;
import com.ICM.GestionCamiones.repositories.ObservacionesRGSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObservacionesRGS_Service {
    @Autowired
    ObservacionesRGSRepository observacionesRGSRepository;

    public List<ObservacionesRGSModel> GetObsxRgs(Long id){
        RGSModel rgs = new RGSModel();
        rgs.setId(id);
        return observacionesRGSRepository.findByRgsModel(rgs);
    }

    //CRUD

    public List<ObservacionesRGSModel> findAll(){
        return observacionesRGSRepository.findAll();
    }

    public Optional<ObservacionesRGSModel> findById(Long id){
        return observacionesRGSRepository.findById(id);
    }

    public ObservacionesRGSModel saveObs(ObservacionesRGSModel observacionesRGSModel){
        return observacionesRGSRepository.save(observacionesRGSModel);
    }
}
