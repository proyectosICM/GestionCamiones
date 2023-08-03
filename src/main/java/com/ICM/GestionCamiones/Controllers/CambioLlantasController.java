package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.CambioLlantasModel;
import com.ICM.GestionCamiones.Service.CambioLlantasService;
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
    public List<CambioLlantasModel> GetAllCambioLlantas(){
       return cambioLlantasService.getAllCambioLlantas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CambioLlantasModel> GetIdCambioLlantas(@PathVariable Long id){
        Optional<CambioLlantasModel> cambiollantas = cambioLlantasService.getByIdCambioLlantas(id);
        if(cambiollantas.isPresent()){
            return new ResponseEntity<>(cambiollantas.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CambioLlantasModel> CreateCambioLlantas(@RequestBody CambioLlantasModel cambioLlantasModel){
        CambioLlantasModel ccambiollantas = cambioLlantasService.createCambioLlantas(cambioLlantasModel);
        return new ResponseEntity<>(ccambiollantas, HttpStatus.CREATED);
    }
}
