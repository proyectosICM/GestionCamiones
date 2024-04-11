package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.CambioLlantasModel;
import com.ICM.GestionCamiones.service.CambioLlantasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cambio-llantas")
public class CambioLlantasController {
    @Autowired
    CambioLlantasService cambioLlantasService;

    @GetMapping
    public List<CambioLlantasModel> findAll(){
       return cambioLlantasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CambioLlantasModel> findById(@PathVariable Long id){
        Optional<CambioLlantasModel> cambiollantas = cambioLlantasService.findById(id);
        if(cambiollantas.isPresent()){
            return new ResponseEntity<>(cambiollantas.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CambioLlantasModel> createCambioLlantas(@RequestBody CambioLlantasModel cambioLlantasModel){
        CambioLlantasModel ccambiollantas = cambioLlantasService.createCambioLlantas(cambioLlantasModel);
        return new ResponseEntity<>(ccambiollantas, HttpStatus.CREATED);
    }
}
