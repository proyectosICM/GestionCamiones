package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.FallasImagen_Model;
import com.ICM.GestionCamiones.Models.RGSModel;
import com.ICM.GestionCamiones.Repositories.FallasImagen_Repository;
import com.ICM.GestionCamiones.Service.FallasImagen_Service;
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

    @GetMapping("/xrgs/{id}")
    public List<FallasImagen_Model> GetbugImagexRGS(@PathVariable Long id){
        return fallasImagenService.GetbugImagexRGS(id);
    }
    //CRUD
    @GetMapping
    public List<FallasImagen_Model> GetAllBugImages(){
        return fallasImagenService.GetAllBugImages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FallasImagen_Model> GetErrorImageById(@PathVariable Long id){
        Optional<FallasImagen_Model> fallasImagen = fallasImagenService.GetErrorImageById(id);
    return new ResponseEntity<>(fallasImagen.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FallasImagen_Model> CreateErrorImage(@RequestBody FallasImagen_Model fallasImagenModel){
        FallasImagen_Model cfallasImagen = fallasImagenService.CreateErrorImage(fallasImagenModel);
        return new ResponseEntity<>(cfallasImagen, HttpStatus.CREATED);
    }
}
