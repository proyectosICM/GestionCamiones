package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.SedesModel;
import com.ICM.GestionCamiones.Service.SedesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/sedes")
public class SedesController {
    @Autowired
    SedesService sedesService;

    @GetMapping
    public List<SedesModel> GetAllSedes(){
        return sedesService.GetAllSedes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SedesModel> GetSedeId(@PathVariable Long id){
        Optional<SedesModel> sede = sedesService.GetSedeId(id);
        if (sede.isEmpty()){
            return new ResponseEntity<>(sede.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<SedesModel> CreateSede(@RequestBody SedesModel sedesModel){
        SedesModel csede = sedesService.CreateSede(sedesModel);
        return new ResponseEntity<>(csede, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SedesModel> EditSede(@RequestBody SedesModel modelosModel, @PathVariable Long id){
        SedesModel esede = sedesService.EditSede(modelosModel, id);
        if (esede!=null){
            return new ResponseEntity<>(esede, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SedesModel> DeleteSede(@PathVariable Long id){
        sedesService.DeleteSede(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
