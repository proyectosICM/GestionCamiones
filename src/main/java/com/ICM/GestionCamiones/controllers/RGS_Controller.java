package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.RGSModel;
import com.ICM.GestionCamiones.service.RGS_Service;
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
@RequestMapping("api/RGS")
public class RGS_Controller {
    @Autowired
    RGS_Service rgsService;

    @GetMapping
    public ResponseEntity<List<RGSModel>> getAllRGS() {
        List<RGSModel> rgsList = rgsService.findAll();
        return new ResponseEntity<>(rgsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RGSModel> getRGSById(@PathVariable Long id) {
        Optional<RGSModel> rgs = rgsService.findById(id);
        return rgs.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByUserAndEstado")
    public ResponseEntity<RGSModel> findByUsuariosModelIdAndEnUso(@RequestParam Long usuarioId, @RequestParam Boolean enUso) {
        Optional<RGSModel> rgsOptional = rgsService.findByUsuariosModelIdAndEnUso(usuarioId, enUso);
        return rgsOptional.map(rgs -> new ResponseEntity<>(rgs, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/checklist")
    public ResponseEntity<Page<RGSModel>> findByCamionId(@RequestParam Long camionId,
                                                         @RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<RGSModel> rgsModels = rgsService.findByCheckListCamionModelCamionesModelId(camionId, pageable);
        return ResponseEntity.ok(rgsModels);
    }

    @PostMapping
    public ResponseEntity<RGSModel> createRGS(@RequestBody RGSModel rgs) {
        RGSModel createdRGS = rgsService.createRGS(rgs);
        return new ResponseEntity<>(createdRGS, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RGSModel> updateRGS(@PathVariable Long id, @RequestBody RGSModel updatedRGS) {
        RGSModel rgs = rgsService.updateRGS(id, updatedRGS);
        if (rgs != null) {
            return new ResponseEntity<>(rgs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRGS(@PathVariable Long id) {
        rgsService.deleteRGS(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
