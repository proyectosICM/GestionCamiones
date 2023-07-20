package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.EmpresasModel;
import com.ICM.GestionCamiones.Models.MarcasModel;
import com.ICM.GestionCamiones.Repositories.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresasService {
    @Autowired
    EmpresasRepository empresasRepository;

    //CRUD
    public List<EmpresasModel> GetAllEmpresa(){
        return empresasRepository.findAll();
    }

    public Optional<EmpresasModel> GetEmpresaId(Long id){
        return empresasRepository.findById(id);
    }

    public EmpresasModel CreateEmpresa(EmpresasModel empresasModel){
        return empresasRepository.save(empresasModel);
    }

    public EmpresasModel EditEmpresa(EmpresasModel empresasModel, Long id){
        Optional<EmpresasModel> existing = empresasRepository.findById(id);
        if(existing.isPresent()){
            EmpresasModel empresa = existing.get();
            empresa.setNombre(empresasModel.getNombre());
            return empresasRepository.save(empresa);
        }
        return null;
    }

    public void DeleteEmpresa(Long id){
        empresasRepository.deleteById(id);
    }
}
