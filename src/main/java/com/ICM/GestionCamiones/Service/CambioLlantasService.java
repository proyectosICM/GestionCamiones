package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.CambioLlantasModel;
import com.ICM.GestionCamiones.Repositories.CambioLlantasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CambioLlantasService {
    @Autowired
    CambioLlantasRepository cambioLlantasRepository;

    public List<CambioLlantasModel> getAllCambioLlantas(){
        return cambioLlantasRepository.findAll();
    }

    public Optional<CambioLlantasModel> getByIdCambioLlantas(Long id){
        return cambioLlantasRepository.findById(id);
    }

    public CambioLlantasModel createCambioLlantas(CambioLlantasModel cambioLlantasModel){
        return cambioLlantasRepository.save(cambioLlantasModel);
    }
}
