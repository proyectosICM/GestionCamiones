package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.CambioLlantasModel;
import com.ICM.GestionCamiones.repositories.CambioLlantasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CambioLlantasService {
    @Autowired
    CambioLlantasRepository cambioLlantasRepository;

    public List<CambioLlantasModel> findAll(){
        return cambioLlantasRepository.findAll();
    }

    public Optional<CambioLlantasModel> findById(Long id){
        return cambioLlantasRepository.findById(id);
    }

    public CambioLlantasModel createCambioLlantas(CambioLlantasModel cambioLlantasModel){
        return cambioLlantasRepository.save(cambioLlantasModel);
    }
}
