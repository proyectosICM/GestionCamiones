package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.MarcasModel;
import com.ICM.GestionCamiones.service.MarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/marcas")
public class MarcasController {
    @Autowired
    MarcasService marcasService;

    @GetMapping
    public List<MarcasModel> findAll(){
        return marcasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcasModel> findById(@PathVariable Long id){
        Optional<MarcasModel> marca = marcasService.findById(id);
        if (marca.isEmpty()){
            return new ResponseEntity<>(marca.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MarcasModel> createMarca(@RequestBody MarcasModel marcasModel){
        MarcasModel cmarca = marcasService.createMarca(marcasModel);
        return new ResponseEntity<>(cmarca, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcasModel> editMarca(@RequestBody MarcasModel marcasModel, @PathVariable Long id){
        MarcasModel emarca = marcasService.editMarca(marcasModel, id);
        if (emarca!=null){
            return new ResponseEntity<>(emarca, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MarcasModel> deleteMarca(@PathVariable Long id){
        marcasService.deleteMarca(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
