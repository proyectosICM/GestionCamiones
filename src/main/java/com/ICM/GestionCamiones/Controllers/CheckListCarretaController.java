package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.CheckListCamionModel;
import com.ICM.GestionCamiones.Models.CheckListCarretaModel;
import com.ICM.GestionCamiones.Service.CheckListCamionService;
import com.ICM.GestionCamiones.Service.CheckListCarretaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/checkListCarreta")
public class CheckListCarretaController {
    @Autowired
    CheckListCarretaService checkListCarretaService;

    //CRUD
    @GetMapping
    public List<CheckListCarretaModel> GetAllCheckList(){
        return checkListCarretaService.GetAllChecklistCarreta();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckListCarretaModel> GetId(@PathVariable Long id){
        Optional<CheckListCarretaModel> clc = checkListCarretaService.GetById(id);
        if (clc.isPresent()){
            return new ResponseEntity<>(clc.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CheckListCarretaModel> GuardarCheckList(@RequestBody CheckListCarretaModel checkListCarretaModel){
        CheckListCarretaModel cchecklist = checkListCarretaService.CreateCLCarreta(checkListCarretaModel);
        return new ResponseEntity<>(cchecklist, HttpStatus.CREATED);
    }
}
