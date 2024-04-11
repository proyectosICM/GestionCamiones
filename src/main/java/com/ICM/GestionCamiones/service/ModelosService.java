package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.ModelosModel;
import com.ICM.GestionCamiones.repositories.ModelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelosService {
    @Autowired
    ModelosRepository modelosRepository;
    //CRUD
    public List<ModelosModel> findAll(){
        return modelosRepository.findAll();
    }

    public Optional<ModelosModel> findById(Long id){
        return modelosRepository.findById(id);
    }

    public ModelosModel createModelo(ModelosModel modelosModel){
        return modelosRepository.save(modelosModel);
    }

    public ModelosModel editModelo(ModelosModel modelosModel, Long id){
        Optional<ModelosModel> existing = modelosRepository.findById(id);
        if(existing.isPresent()){
            ModelosModel modelo = existing.get();
            modelo.setNombre(modelosModel.getNombre());
            return modelosRepository.save(modelo);
        }
        return null;
    }

    public void deleteModelo(Long id){
        modelosRepository.deleteById(id);
    }
}
