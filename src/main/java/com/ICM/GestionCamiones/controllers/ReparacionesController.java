package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.ReparacionesModel;
import com.ICM.GestionCamiones.service.ReparacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reparaciones")
public class ReparacionesController {
    @Autowired
    ReparacionesService reparacionesService;

    @GetMapping
    public List<ReparacionesModel> findAll(){
        return reparacionesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReparacionesModel>  findById(@PathVariable Long id){
        Optional<ReparacionesModel> reparaciones = reparacionesService.findById(id);
        return new ResponseEntity<>(reparaciones.get(), HttpStatus.OK);
    }

    @GetMapping("/xrgs/{rgs}")
    public ResponseEntity<List<ReparacionesModel>> verxRGS(@PathVariable Long rgs){
        List<ReparacionesModel> reparaciones = reparacionesService.verxRGS(rgs);
        if (!reparaciones.isEmpty()) {
            return new ResponseEntity<>(reparaciones, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ReparacionesModel> saveS (@RequestBody ReparacionesModel reparacionesModel){
        ReparacionesModel creparaciones = reparacionesService.saveS(reparacionesModel);
        return new ResponseEntity<>(creparaciones, HttpStatus.OK);
    }


}
