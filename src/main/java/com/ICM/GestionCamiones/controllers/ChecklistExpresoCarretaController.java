package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.ChecklistExpresoCamionModel;
import com.ICM.GestionCamiones.models.ChecklistExpresoCarretaModel;
import com.ICM.GestionCamiones.service.CheckListExpresoCamionService;
import com.ICM.GestionCamiones.service.ChecklistExpresoCarretaService;
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
@RequestMapping("api/expreso-carreta")
public class ChecklistExpresoCarretaController {
    @Autowired
    ChecklistExpresoCarretaService checklistExpresoCarretaService;

    @GetMapping
    public List<ChecklistExpresoCarretaModel> GetAllCle(){
        return checklistExpresoCarretaService.GetAllCle();
    }

    @GetMapping("/findByCamionesModelId")
    public ResponseEntity<Page<ChecklistExpresoCarretaModel>> findByCamionesModelId(
            @RequestParam Long camionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "9") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ChecklistExpresoCarretaModel> checklists = checklistExpresoCarretaService.findByCamionesModelId(camionId, pageable);
        return ResponseEntity.ok(checklists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChecklistExpresoCarretaModel> GetByIdCle(@PathVariable Long id){
        Optional<ChecklistExpresoCarretaModel> cle = checklistExpresoCarretaService.GetByIdCle(id);
        if(cle.isPresent()){
            return new ResponseEntity<>(cle.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ChecklistExpresoCarretaModel> CreateCle(@RequestBody ChecklistExpresoCarretaModel checklistExpresoCarretaModel){
        ChecklistExpresoCarretaModel ccle = checklistExpresoCarretaService.CreateCle(checklistExpresoCarretaModel);
        return new ResponseEntity<>(ccle, HttpStatus.CREATED);
    }
}
