package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.ModelosModel;
import com.ICM.GestionCamiones.service.ModelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/modelos")
public class ModelosController {
    @Autowired
    ModelosService modelosService;

    @GetMapping
    public List<ModelosModel> findAll(){
        return modelosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelosModel> findById(@PathVariable Long id){
        Optional<ModelosModel> modelo = modelosService.findById(id);
        if (modelo.isEmpty()){
            return new ResponseEntity<>(modelo.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ModelosModel> createModelo(@RequestBody ModelosModel modelosModel){
        ModelosModel cmodelo = modelosService.createModelo(modelosModel);
        return new ResponseEntity<>(cmodelo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelosModel> editModelo(@RequestBody ModelosModel modelosModel, @PathVariable Long id){
        ModelosModel emodelo = modelosService.editModelo(modelosModel, id);
        if (emodelo!=null){
            return new ResponseEntity<>(emodelo, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModelosModel> deleteModelo(@PathVariable Long id){
        modelosService.deleteModelo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
