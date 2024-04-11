package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.TiposCModel;
import com.ICM.GestionCamiones.repositories.TiposCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiposCService {
    @Autowired
    TiposCRepository tiposCRepository;

    public List<TiposCModel> GetAllTC(){
        return tiposCRepository.findAll();
    }

    public Optional<TiposCModel> GetTCId(Long id){
        return tiposCRepository.findById(id);
    }

    public TiposCModel CreateTC(TiposCModel tiposCModel){
        return tiposCRepository.save(tiposCModel);
    }

    public TiposCModel EditTC(TiposCModel tiposCModel, Long id){
        Optional<TiposCModel> existing = tiposCRepository.findById(id);
        if (existing.isPresent()){
            TiposCModel tipostc = existing.get();
            tipostc.setNombre(tiposCModel.getNombre());
            return tiposCRepository.save(tiposCModel);
        }
        return null;
    }

    public void DeleteTC(Long id){
        tiposCRepository.deleteById(id);
    }
}
