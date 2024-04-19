package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.ChecklistExpresoCamionModel;
import com.ICM.GestionCamiones.service.CheckListExpresoCamionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/expreso-camion")
public class CheckListCamionExpresoController {
    @Autowired
    CheckListExpresoCamionService checkListExpresoCamionService;

    @GetMapping
    public List<ChecklistExpresoCamionModel> GetAllCle(){
        return checkListExpresoCamionService.GetAllCle();
    }

    @GetMapping("/findByCamionesModelId")
    public ResponseEntity<Page<ChecklistExpresoCamionModel>> findByCamionesModelId(
            @RequestParam Long camionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "9") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ChecklistExpresoCamionModel> checklists = checkListExpresoCamionService.findByCamionesModelId(camionId, pageable);
        return ResponseEntity.ok(checklists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChecklistExpresoCamionModel> GetByIdCle(@PathVariable Long id){
        Optional<ChecklistExpresoCamionModel> cle = checkListExpresoCamionService.GetByIdCle(id);
        if(cle.isPresent()){
            return new ResponseEntity<>(cle.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ChecklistExpresoCamionModel> CreateCle(@RequestBody ChecklistExpresoCamionModel checklistExpresoCamionModel){
        ChecklistExpresoCamionModel ccle = checkListExpresoCamionService.CreateCle(checklistExpresoCamionModel);
        return new ResponseEntity<>(ccle, HttpStatus.CREATED);
    }
}
