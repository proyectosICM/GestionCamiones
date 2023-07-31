package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.CheckListModel;
import com.ICM.GestionCamiones.Service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/checkList")
public class CheckListController {
    @Autowired
    CheckListService checkListService;

    @GetMapping("/xcamion/{id}")
    public List<CheckListModel> xCamion(@PathVariable Long id){
        return checkListService.ListarxCamion(id);
    }

    //CRUD
    @GetMapping
    public List<CheckListModel> GetAllCheckList(){
        return checkListService.GetAllCheckLists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckListModel> GetId(@PathVariable Long id){
        Optional<CheckListModel> clc = checkListService.Listarxid(id);
        if (clc.isPresent()){
            return new ResponseEntity<>(clc.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CheckListModel> GuardarCheckList(@RequestBody CheckListModel checkListModel){
        CheckListModel cchecklist = checkListService.GuardarCheckList(checkListModel);
        return new ResponseEntity<>(cchecklist, HttpStatus.CREATED);
    }
}
