package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.FallasImagen_Model;
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

    public List<FallasImagen_Model> GetAllBugImages(){
        return fallasImagenRepository.findAll();
    }

    public Optional<FallasImagen_Model> GetErrorImageById(Long id){
        return fallasImagenRepository.findById(id);
    }

    public FallasImagen_Model CreateErrorImage(FallasImagen_Model fallasImagenModel){
        return fallasImagenRepository.save(fallasImagenModel);
    }
}
