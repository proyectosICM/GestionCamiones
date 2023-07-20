package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.EmpresasModel;
import com.ICM.GestionCamiones.Models.MarcasModel;
import com.ICM.GestionCamiones.Service.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/empresas")
public class EmpresasController {
    @Autowired
    EmpresasService empresasService;

    @GetMapping
    public List<EmpresasModel> GetAllEmpresa(){
        return empresasService.GetAllEmpresa();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresasModel> GetIdEmpresa(@PathVariable Long id){
        Optional<EmpresasModel> empresa = empresasService.GetEmpresaId(id);
        if (empresa.isEmpty()){
            return new ResponseEntity<>(empresa.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<EmpresasModel> CreateEmpresa(@RequestBody EmpresasModel empresasModel){
        EmpresasModel cempresa = empresasService.CreateEmpresa(empresasModel);
        return new ResponseEntity<>(cempresa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresasModel> EditEmpresa(@RequestBody EmpresasModel empresasModel, @PathVariable Long id){
        EmpresasModel eempresa = empresasService.EditEmpresa(empresasModel, id);
        if (eempresa!=null){
            return new ResponseEntity<>(eempresa, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpresasModel> DeleteEmpresa(@PathVariable Long id){
        empresasService.DeleteEmpresa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
