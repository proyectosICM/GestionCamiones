package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.SedesModel;
import com.ICM.GestionCamiones.repositories.SedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedesService {
    @Autowired
    SedesRepository sedesRepository;

    public List<SedesModel> GetAllSedes(){
        return sedesRepository.findAll();
    }

    public Optional<SedesModel> GetSedeId(Long id){
        return sedesRepository.findById(id);
    }

    public SedesModel CreateSede(SedesModel sedesModel){
        return sedesRepository.save(sedesModel);
    }

    public SedesModel EditSede(SedesModel sedesModel, Long id){
        Optional<SedesModel> existing = sedesRepository.findById(id);
        if (existing.isPresent()){
            SedesModel sede = existing.get();
            sede.setNombre(sedesModel.getNombre());
            return sedesRepository.save(sede);
        }
        return null;
    }

    public void DeleteSede(Long id){
        sedesRepository.deleteById(id);
    }
}
