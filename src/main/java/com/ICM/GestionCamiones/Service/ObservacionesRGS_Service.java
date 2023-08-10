package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.ObservacionesRGSModel;
import com.ICM.GestionCamiones.Models.RGSModel;
import com.ICM.GestionCamiones.Repositories.ObservacionesRGSRepository;
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

    public List<ObservacionesRGSModel> GetAllObs(){
        return observacionesRGSRepository.findAll();
    }

    public Optional<ObservacionesRGSModel> GetObsById(Long id){
        return observacionesRGSRepository.findById(id);
    }

    public ObservacionesRGSModel SaveObs(ObservacionesRGSModel observacionesRGSModel){
        return observacionesRGSRepository.save(observacionesRGSModel);
    }
}
