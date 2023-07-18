package com.ICM.GestionCamiones.Security;

import com.ICM.GestionCamiones.Models.ModelosModel;
import com.ICM.GestionCamiones.Repositories.ModelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class ModelosService {
    @Autowired
    ModelosRepository modelosRepository;
    //CRUD
    public List<ModelosModel> ListarModelos(){
        return modelosRepository.findAll();
    }

    public Optional<ModelosModel> ListarModeloId(Long id){
        return modelosRepository.findById(id);
    }

    public ModelosModel CrearModelo(ModelosModel modelosModel){
        return modelosRepository.save(modelosModel);
    }

    public ModelosModel EditarModelo(ModelosModel modelosModel, Long id){
        Optional<ModelosModel> existing = modelosRepository.findById(id);
        if(existing.isPresent()){
            ModelosModel modelo = existing.get();
            modelo.setNombre(modelosModel.getNombre());
            return modelosRepository.save(modelo);
        }
        return null;
    }

    public void EliminarModelo(Long id){
        modelosRepository.deleteById(id);
    }
}
