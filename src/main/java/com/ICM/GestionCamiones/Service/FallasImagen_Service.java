package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.FallasImagen_Model;
import com.ICM.GestionCamiones.Models.RGSModel;
import com.ICM.GestionCamiones.Repositories.FallasImagen_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class FallasImagen_Service {
    @Autowired
    FallasImagen_Repository fallasImagenRepository;

    public List<FallasImagen_Model> GetbugImagexRGS(Long idRgs){
        RGSModel rgs = new RGSModel();
        rgs.setId(idRgs);
        return fallasImagenRepository.findByRgsModel(rgs);
    }

    //CRUD

    public List<FallasImagen_Model> GetAllBugImages(){
        return fallasImagenRepository.findAll();
    }

    public Optional<FallasImagen_Model> GetErrorImageById(Long id){
        return fallasImagenRepository.findById(id);
    }

    public FallasImagen_Model CreateErrorImage(FallasImagen_Model fallasImagenModel){
        return fallasImagenRepository.save(fallasImagenModel);
    }

    public FallasImagen_Model EditErrorImage(Long id, FallasImagen_Model fallasImagenModel){
        Optional<FallasImagen_Model> existing = fallasImagenRepository.findById(id);
        if(existing.isPresent()){
            FallasImagen_Model errorImage = existing.get();
            errorImage.setObservacion(fallasImagenModel.getObservacion());
            errorImage.setRgsModel(fallasImagenModel.getRgsModel());
            return fallasImagenRepository.save(errorImage);
        }
        return null;
    }
}
