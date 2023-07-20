package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.ModelosModel;
import com.ICM.GestionCamiones.Repositories.ModelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelosService {
    @Autowired
    ModelosRepository modelosRepository;
    //CRUD
    public List<ModelosModel> GetAllModelos(){
        return modelosRepository.findAll();
    }

    public Optional<ModelosModel> GetModeloId(Long id){
        return modelosRepository.findById(id);
    }

    public ModelosModel CreateModelo(ModelosModel modelosModel){
        return modelosRepository.save(modelosModel);
    }

    public ModelosModel EditModelo(ModelosModel modelosModel, Long id){
        Optional<ModelosModel> existing = modelosRepository.findById(id);
        if(existing.isPresent()){
            ModelosModel modelo = existing.get();
            modelo.setNombre(modelosModel.getNombre());
            return modelosRepository.save(modelo);
        }
        return null;
    }

    public void DeleteModelo(Long id){
        modelosRepository.deleteById(id);
    }
}
