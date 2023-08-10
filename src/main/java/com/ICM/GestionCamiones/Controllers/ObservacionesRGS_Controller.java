package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.ObservacionesRGSModel;
import com.ICM.GestionCamiones.Repositories.ObservacionesRGSRepository;
import com.ICM.GestionCamiones.Service.ObservacionesRGS_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Obs")
public class ObservacionesRGS_Controller {
    @Autowired
    ObservacionesRGS_Service observacionesRGSService;

    @GetMapping("/xRGS/{id}")
    public ResponseEntity<List<ObservacionesRGSModel>> ObsxRGS(@PathVariable Long id){
        List<ObservacionesRGSModel> obsxRgs = observacionesRGSService.GetObsxRgs(id);
        return new ResponseEntity<>(obsxRgs, HttpStatus.OK);
    }

    //CRUD

    @GetMapping
    public List<ObservacionesRGSModel> GetAll(){
        return observacionesRGSService.GetAllObs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObservacionesRGSModel> GetById(@PathVariable Long id){
        Optional<ObservacionesRGSModel> obs = observacionesRGSService.GetObsById(id);
        if (obs.isPresent()){
            return new ResponseEntity<>(obs.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ObservacionesRGSModel> SaveObs(@RequestBody ObservacionesRGSModel observacionesRGSModel){
        ObservacionesRGSModel cobs = observacionesRGSService.SaveObs(observacionesRGSModel);
        return new ResponseEntity<>(cobs, HttpStatus.CREATED);
    }


}
