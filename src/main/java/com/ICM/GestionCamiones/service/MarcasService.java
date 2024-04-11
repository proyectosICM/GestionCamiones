package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.MarcasModel;
import com.ICM.GestionCamiones.repositories.MarcasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcasService {
    @Autowired
    MarcasRepository marcasRepository;
    //CRUD
    public List<MarcasModel> findAll(){
        return marcasRepository.findAll();
    }

    public Optional<MarcasModel> findById(Long id){
        return marcasRepository.findById(id);
    }

    public MarcasModel createMarca(MarcasModel marcasModel){
        return marcasRepository.save(marcasModel);
    }

    public MarcasModel editMarca(MarcasModel marcasModel, Long id){
        Optional<MarcasModel> existing = marcasRepository.findById(id);
        if(existing.isPresent()){
            MarcasModel marcas = existing.get();
            marcas.setNombre(marcasModel.getNombre());
            return marcasRepository.save(marcas);
        }
        return null;
    }

    public void deleteMarca(Long id){
        marcasRepository.deleteById(id);
    }
}
