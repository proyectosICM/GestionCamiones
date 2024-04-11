package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.CheckListExpresoModel;
import com.ICM.GestionCamiones.service.CheckListExpresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cle")
public class CheckListExpresoController {
    @Autowired
    CheckListExpresoService checkListExpresoService;

    @GetMapping
    public List<CheckListExpresoModel> GetAllCle(){
        return checkListExpresoService.GetAllCle();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckListExpresoModel> GetByIdCle(@PathVariable Long id){
        Optional<CheckListExpresoModel> cle = checkListExpresoService.GetByIdCle(id);
        if(cle.isPresent()){
            return new ResponseEntity<>(cle.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CheckListExpresoModel> CreateCle(@RequestBody  CheckListExpresoModel checkListExpresoModel){
        CheckListExpresoModel ccle = checkListExpresoService.CreateCle(checkListExpresoModel);
        return new ResponseEntity<>(ccle, HttpStatus.CREATED);
    }
}
