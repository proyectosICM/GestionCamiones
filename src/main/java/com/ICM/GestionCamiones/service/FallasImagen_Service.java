package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.FallasImagen_Model;
import com.ICM.GestionCamiones.models.RGSModel;
import com.ICM.GestionCamiones.repositories.FallasImagen_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FallasImagen_Service {
    @Autowired
    FallasImagen_Repository fallasImagenRepository;


    //CRUD

    public List<FallasImagen_Model> findAll(){
        return fallasImagenRepository.findAll();
    }

    public Optional<FallasImagen_Model> findById(Long id){
        return fallasImagenRepository.findById(id);
    }

    public FallasImagen_Model createErrorImage(FallasImagen_Model fallasImagenModel){
        return fallasImagenRepository.save(fallasImagenModel);
    }

    public FallasImagen_Model editErrorImage(Long id, FallasImagen_Model fallasImagenModel){
        Optional<FallasImagen_Model> existing = fallasImagenRepository.findById(id);
        if(existing.isPresent()){
            FallasImagen_Model errorImage = existing.get();
            errorImage.setObservacion(fallasImagenModel.getObservacion());
            // errorImage.setRgsModel(fallasImagenModel.getRgsModel());
            return fallasImagenRepository.save(errorImage);
        }
        return null;
    }
}
