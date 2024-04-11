package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.EmpresasModel;
import com.ICM.GestionCamiones.service.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/empresas")
public class EmpresasController {
    @Autowired
    EmpresasService empresasService;

    @GetMapping
    public List<EmpresasModel> findAll(){
        return empresasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresasModel> findById(@PathVariable Long id){
        Optional<EmpresasModel> empresa = empresasService.findById(id);
        if (empresa.isEmpty()){
            return new ResponseEntity<>(empresa.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<EmpresasModel> createEmpresa(@RequestBody EmpresasModel empresasModel){
        EmpresasModel cempresa = empresasService.createEmpresa(empresasModel);
        return new ResponseEntity<>(cempresa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresasModel> editEmpresa(@RequestBody EmpresasModel empresasModel, @PathVariable Long id){
        EmpresasModel eempresa = empresasService.editEmpresa(empresasModel, id);
        if (eempresa!=null){
            return new ResponseEntity<>(eempresa, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpresasModel> deleteEmpresa(@PathVariable Long id){
        empresasService.deleteEmpresa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
