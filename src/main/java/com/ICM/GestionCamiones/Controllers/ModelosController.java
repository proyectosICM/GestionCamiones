package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.ModelosModel;
import com.ICM.GestionCamiones.Service.ModelosService;
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
    public List<ModelosModel> GetAllModelos(){
        return modelosService.GetAllModelos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelosModel> GetModeloId(@PathVariable Long id){
        Optional<ModelosModel> modelo = modelosService.GetModeloId(id);
        if (modelo.isEmpty()){
            return new ResponseEntity<>(modelo.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ModelosModel> CreateModelo(@RequestBody ModelosModel modelosModel){
        ModelosModel cmodelo = modelosService.CreateModelo(modelosModel);
        return new ResponseEntity<>(cmodelo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelosModel> EditModelo(@RequestBody ModelosModel modelosModel, @PathVariable Long id){
        ModelosModel emodelo = modelosService.EditModelo(modelosModel, id);
        if (emodelo!=null){
            return new ResponseEntity<>(emodelo, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModelosModel> DeleteModelo(@PathVariable Long id){
        modelosService.DeleteModelo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
