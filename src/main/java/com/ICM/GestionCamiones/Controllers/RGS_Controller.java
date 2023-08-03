package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.RGS_Model;
import com.ICM.GestionCamiones.Service.RGS_Service;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/RGS")
public class RGS_Controller {
    @Autowired
    RGS_Service rgsService;

    @GetMapping
    public List<RGS_Model> GetAllRGS(){
        return rgsService.getAllRgsModel();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RGS_Model> GetIdRGS(@PathVariable Long id ){
        Optional<RGS_Model> cRGS = rgsService.getIdRgs(id);
        if(cRGS.isPresent()){
            return new ResponseEntity<>(cRGS.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<RGS_Model> CreateIdRGS(@RequestBody RGS_Model rgsModel){
        RGS_Model cRGS = rgsService.saveRgs(rgsModel);
        return new ResponseEntity<>(cRGS, HttpStatus.CREATED);
    }
}
