package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.ReparacionesModel;
import com.ICM.GestionCamiones.Repositories.ReparacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReparacionesService {
    @Autowired
    ReparacionesRepository reparacionesRepository;

    public List<ReparacionesModel> GetAllS(){
        return reparacionesRepository.findAll();
    }

    public Optional<ReparacionesModel> GetByIdS(Long id){
        return reparacionesRepository.findById(id);
    }

    public ReparacionesModel SaveS(ReparacionesModel reparacionesModel){
        return reparacionesRepository.save(reparacionesModel);
    }


}
