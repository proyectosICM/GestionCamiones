package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.RGSModel;
import com.ICM.GestionCamiones.models.ReparacionesModel;
import com.ICM.GestionCamiones.repositories.ReparacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReparacionesService {
    @Autowired
    ReparacionesRepository reparacionesRepository;

    public List<ReparacionesModel> findAll(){
        return reparacionesRepository.findAll();
    }

    public Optional<ReparacionesModel> findById(Long id){
        return reparacionesRepository.findById(id);
    }

    public ReparacionesModel saveS(ReparacionesModel reparacionesModel){
        return reparacionesRepository.save(reparacionesModel);
    }

    public List<ReparacionesModel> verxRGS(Long rgsId){
        RGSModel rgs = new RGSModel();
        rgs.setId(rgsId);
        return reparacionesRepository.findByRgsModel(rgs);
    }

    /*
    public ResponseEntity<ReparacionesModel> VerxRGS(Long rgsId){
        RGSModel rgs = new RGSModel();
        rgs.setId(rgsId);
        List<ReparacionesModel> reparaciones = reparacionesRepository.findByRGSModel(rgs);
        if(reparaciones != null){
            return new ResponseEntity<>(reparaciones.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
     */
}
