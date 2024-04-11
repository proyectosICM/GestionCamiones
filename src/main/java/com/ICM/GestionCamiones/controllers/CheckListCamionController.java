package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.CheckListCamionModel;
import com.ICM.GestionCamiones.service.CheckListCamionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/checkListCamion")
public class CheckListCamionController {
    @Autowired
    CheckListCamionService checkListCamionService;

    @GetMapping("/xcamion/{id}")
    public List<CheckListCamionModel> xCamion(@PathVariable Long id){
        return checkListCamionService.ListarxCamion(id);
    }

    //CRUD
    @GetMapping
    public List<CheckListCamionModel> GetAllCheckList(){
        return checkListCamionService.GetAllCheckLists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckListCamionModel> GetId(@PathVariable Long id){
        Optional<CheckListCamionModel> clc = checkListCamionService.Listarxid(id);
        if (clc.isPresent()){
            return new ResponseEntity<>(clc.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CheckListCamionModel> GuardarCheckList(@RequestBody CheckListCamionModel checkListCamionModel){
        CheckListCamionModel cchecklist = checkListCamionService.GuardarCheckList(checkListCamionModel);
        return new ResponseEntity<>(cchecklist, HttpStatus.CREATED);
    }
}
