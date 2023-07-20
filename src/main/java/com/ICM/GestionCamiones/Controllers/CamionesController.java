package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.CamionesModel;
import com.ICM.GestionCamiones.Service.CamionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/camiones")
public class CamionesController {
    @Autowired
    CamionesService camionesService;

    @GetMapping
    public List<CamionesModel> GetAllCamiones(){
        return camionesService.GetCamion();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CamionesModel> GetIdCamion(@PathVariable Long id){
        Optional<CamionesModel> camion = camionesService.GetCamionId(id);
        if (camion.isPresent()){
            return new ResponseEntity<>(camion.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CamionesModel> CreateCamion(@RequestBody CamionesModel camionesModel){
        CamionesModel ccamion = camionesService.CreateCamion(camionesModel);
        return new ResponseEntity<>(ccamion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CamionesModel> EditCamion(@RequestBody CamionesModel camionesModel, @PathVariable Long id){
        CamionesModel ecamion = camionesService.EditCamion(camionesModel, id);
        if(ecamion!=null){
            return new ResponseEntity<>(ecamion, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CamionesModel> DeleteCamion(@PathVariable Long id){
        camionesService.DeleteCamion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
