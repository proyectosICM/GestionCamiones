package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.RGSModel;
import com.ICM.GestionCamiones.Service.RGS_Service;
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

    @GetMapping("/xempresa-sede/{empresa}/{sede}/{estado}")
    public List<RGSModel> GetxEmpresaXSede(@PathVariable Long empresa, @PathVariable Long sede, @PathVariable Boolean estado){
        return rgsService.getxEmpresaAndxSede(empresa, sede, estado);
    }



    // CRUD
    @GetMapping
    public List<RGSModel> GetAllRGS(){
        return rgsService.getAllRgsModel();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RGSModel> GetIdRGS(@PathVariable Long id ){
        Optional<RGSModel> cRGS = rgsService.getIdRgs(id);
        if(cRGS.isPresent()){
            return new ResponseEntity<>(cRGS.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<RGSModel> CreateIdRGS(@RequestBody RGSModel rgsModel){
        RGSModel cRGS = rgsService.saveRgs(rgsModel);
        return new ResponseEntity<>(cRGS, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RGSModel> EditRgs(@PathVariable Long id, @RequestBody RGSModel rgsModel){
        RGSModel ergs = rgsService.EditRgs(id, rgsModel);
        if(ergs!=null){
            return new ResponseEntity<>(ergs, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
