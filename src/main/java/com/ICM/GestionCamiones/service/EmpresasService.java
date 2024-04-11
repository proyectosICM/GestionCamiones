package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.EmpresasModel;
import com.ICM.GestionCamiones.repositories.EmpresasRepository;
import com.ICM.GestionCamiones.utils.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresasService {
    @Autowired
    EmpresasRepository empresasRepository;

    @Autowired
    private DirectoryService directoryService;

    //CRUD
    public List<EmpresasModel> findAll(){
        return empresasRepository.findAll();
    }

    public Optional<EmpresasModel> findById(Long id){
        return empresasRepository.findById(id);
    }

    public EmpresasModel createEmpresa(EmpresasModel empresasModel){
        EmpresasModel savedCompany = empresasRepository.save(empresasModel);
        directoryService.createDirectoryWithName(savedCompany.getNombre());

        return savedCompany;
    }

    public EmpresasModel editEmpresa(EmpresasModel empresasModel, Long id){
        Optional<EmpresasModel> existing = empresasRepository.findById(id);
        if(existing.isPresent()){
            EmpresasModel empresa = existing.get();
            empresa.setNombre(empresasModel.getNombre());
            return empresasRepository.save(empresa);
        }
        return null;
    }

    public void deleteEmpresa(Long id){
        empresasRepository.deleteById(id);
    }
}
