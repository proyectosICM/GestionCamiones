package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.RolesModel;
import com.ICM.GestionCamiones.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/roles")
public class RolesController {
    @Autowired
    RolesService rolesService;

    @GetMapping
    public List<RolesModel> GetAllRoles(){
        return rolesService.GetAllRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesModel> GetRolId(@PathVariable Long id){
        Optional<RolesModel> rol = rolesService.GetRolId(id);
        if (rol.isEmpty()){
            return new ResponseEntity<>(rol.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<RolesModel> CreateRol(@RequestBody RolesModel rolesModel){
        RolesModel crol = rolesService.CreaateRol(rolesModel);
        return new ResponseEntity<>(crol, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesModel> EditRol(@RequestBody RolesModel rolesModel, @PathVariable Long id){
        RolesModel erol = rolesService.EditRol(rolesModel, id);
        if (erol!=null){
            return new ResponseEntity<>(erol, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RolesModel> DeleteRol(@PathVariable Long id){
        rolesService.DeleteRol(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
