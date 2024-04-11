package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.FallasImagen_Model;
import com.ICM.GestionCamiones.service.FallasImagen_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/fallas-imagen")
public class FallasImagen_Controller {
    @Autowired
    FallasImagen_Service fallasImagenService;

    //CRUD
    @GetMapping
    public List<FallasImagen_Model> findAll(){
        return fallasImagenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FallasImagen_Model> findById(@PathVariable Long id){
        Optional<FallasImagen_Model> fallasImagen = fallasImagenService.findById(id);
    return new ResponseEntity<>(fallasImagen.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FallasImagen_Model> createErrorImage(@RequestBody FallasImagen_Model fallasImagenModel){
        FallasImagen_Model cfallasImagen = fallasImagenService.createErrorImage(fallasImagenModel);
        return new ResponseEntity<>(cfallasImagen, HttpStatus.CREATED);
    }
}
