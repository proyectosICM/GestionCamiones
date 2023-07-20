package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.SedesModel;
import com.ICM.GestionCamiones.Models.TiposCModel;
import com.ICM.GestionCamiones.Service.TiposCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tipoc")
public class TiposCController {
    @Autowired
    TiposCService tiposCService;

    @GetMapping
    public List<TiposCModel> GetAllTiposC(){
        return tiposCService.GetAllTC();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiposCModel> GetTipoCId(@PathVariable Long id){
        Optional<TiposCModel> tipoc = tiposCService.GetTCId(id);
        if (tipoc.isEmpty()){
            return new ResponseEntity<>(tipoc.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TiposCModel> CreateTipoC(@RequestBody TiposCModel tiposCModel){
        TiposCModel ctipoc = tiposCService.CreateTC(tiposCModel);
        return new ResponseEntity<>(ctipoc, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TiposCModel> EditTipoC(@RequestBody TiposCModel tiposCModel, @PathVariable Long id){
        TiposCModel etipoc = tiposCService.EditTC(tiposCModel, id);
        if (etipoc!=null){
            return new ResponseEntity<>(etipoc, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TiposCModel> DeleteTipoC(@PathVariable Long id){
        tiposCService.DeleteTC(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
