package com.ICM.GestionCamiones.Security;

import com.ICM.GestionCamiones.Models.SedesModel;
import com.ICM.GestionCamiones.Repositories.SedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedesService {
    @Autowired
    SedesRepository sedesRepository;

    public List<SedesModel> ListarSedes(){
        return sedesRepository.findAll();
    }

    public Optional<SedesModel> ListarSedeId(Long id){
        return sedesRepository.findById(id);
    }

    public SedesModel CrearSede(SedesModel sedesModel){
        return sedesRepository.save(sedesModel);
    }

    public SedesModel EditarSede(SedesModel sedesModel, Long id){
        Optional<SedesModel> existing = sedesRepository.findById(id);
        if (existing.isPresent()){
            SedesModel sede = existing.get();
            sede.setNombre(sedesModel.getNombre());
            return sedesRepository.save(sede);
        }
        return null;
    }

    public void EliminarSede(Long id){
        sedesRepository.deleteById(id);
    }
}
