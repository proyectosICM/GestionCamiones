package com.ICM.GestionCamiones.Security;

import com.ICM.GestionCamiones.Models.MarcasModel;
import com.ICM.GestionCamiones.Repositories.MarcasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcasService {
    @Autowired
    MarcasRepository marcasRepository;
    //CRUD
    public List<MarcasModel> ListarMarcas(){
        return marcasRepository.findAll();
    }

    public Optional<MarcasModel> ListarMarcasId(Long id){
        return marcasRepository.findById(id);
    }

    public MarcasModel CrearMarca(MarcasModel marcasModel){
        return marcasRepository.save(marcasModel);
    }

    public MarcasModel EditarMarca(MarcasModel marcasModel, Long id){
        Optional<MarcasModel> existing = marcasRepository.findById(id);
        if(existing.isPresent()){
            MarcasModel marcas = existing.get();
            marcas.setNombre(marcasModel.getNombre());
            return marcasRepository.save(marcas);
        }
        return null;
    }

    public void EliminarMarca(Long id){
        marcasRepository.deleteById(id);
    }
}
