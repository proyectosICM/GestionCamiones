package com.ICM.GestionCamiones.Security;

import com.ICM.GestionCamiones.Models.RolesModel;
import com.ICM.GestionCamiones.Repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    RolesRepository rolesRepository;

    //CRUD
    public List<RolesModel> ListarRoles(){
        return rolesRepository.findAll();
    }

    public Optional<RolesModel> ListarRolId(Long id){
        return rolesRepository.findById(id);
    }

    public RolesModel CrearRol(RolesModel rolesModel){
        return rolesRepository.save(rolesModel);
    }

    public RolesModel EditarRol(RolesModel rolesModel, Long id){
        Optional<RolesModel> existing =  rolesRepository.findById(id);
        if(existing.isPresent()){
            RolesModel rol = existing.get();
            rol.setNombre(rolesModel.getNombre());
            return rolesRepository.save(rol);
        }
        return null;
    }

    public void EliminarRol(Long id){
        rolesRepository.deleteById(id);
    }
}
