package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.MarcasModel;
import com.ICM.GestionCamiones.Service.MarcasService;
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
    public List<MarcasModel> GetAllMarca(){
        return marcasService.GetMarcas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcasModel> GetIdMarca(@PathVariable Long id){
        Optional<MarcasModel> marca = marcasService.GetMarcasId(id);
        if (marca.isEmpty()){
            return new ResponseEntity<>(marca.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MarcasModel> CreateMarca(@RequestBody MarcasModel marcasModel){
        MarcasModel cmarca = marcasService.CreateMarca(marcasModel);
        return new ResponseEntity<>(cmarca, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcasModel> EditMarca(@RequestBody MarcasModel marcasModel, @PathVariable Long id){
        MarcasModel emarca = marcasService.EditMarca(marcasModel, id);
        if (emarca!=null){
            return new ResponseEntity<>(emarca, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MarcasModel> DeleteMarca(@PathVariable Long id){
        marcasService.DeleteMarca(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
