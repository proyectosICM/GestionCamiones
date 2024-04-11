package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.RolesModel;
import com.ICM.GestionCamiones.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    RolesRepository rolesRepository;

    //CRUD
    public List<RolesModel> GetAllRoles(){
        return rolesRepository.findAll();
    }

    public Optional<RolesModel> GetRolId(Long id){
        return rolesRepository.findById(id);
    }

    public RolesModel CreaateRol(RolesModel rolesModel){
        return rolesRepository.save(rolesModel);
    }

    public RolesModel EditRol(RolesModel rolesModel, Long id){
        Optional<RolesModel> existing =  rolesRepository.findById(id);
        if(existing.isPresent()){
            RolesModel rol = existing.get();
            rol.setNombre(rolesModel.getNombre());
            return rolesRepository.save(rol);
        }
        return null;
    }

    public void DeleteRol(Long id){
        rolesRepository.deleteById(id);
    }
}
