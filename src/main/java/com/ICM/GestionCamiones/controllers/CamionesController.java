package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.CamionesModel;
import com.ICM.GestionCamiones.models.EmpresasModel;
import com.ICM.GestionCamiones.models.SedesModel;
import com.ICM.GestionCamiones.service.CamionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/camiones")
public class CamionesController {
    @Autowired
    CamionesService camionesService;


    @GetMapping("/camiones")
    public Page<CamionesModel> getCamionesByCriteria(
            @RequestParam("empresasId") Long empresasId,
            @RequestParam("sedesId") Long sedesId,
            @RequestParam("estado") Boolean estado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return camionesService.findByEmpresasModelIdAndSedesModelIdAndEstado(empresasId, sedesId, estado, pageable);
    }

    @GetMapping("estado/{estado}/{id}")
    public List<CamionesModel> GetCamEmpxEst(@PathVariable Boolean estado, @PathVariable Long id){
        EmpresasModel empresa = new EmpresasModel();
        empresa.setId(id);
        return camionesService.ListarCamionesxEmpresaEst(empresa, estado);
    }

    @GetMapping("/xsede/{empresaid}/{sedeid}/{estado}")
    public List<CamionesModel> GetCamEmpSede(@PathVariable Long empresaid, @PathVariable Long sedeid, @PathVariable Boolean estado){
        EmpresasModel empresa = new EmpresasModel();
        empresa.setId(empresaid);

        SedesModel sedes = new SedesModel();
        sedes.setId(sedeid);

        return camionesService.ListarxEmpresaxSedexEstado(empresa, sedes, estado);
    }

    @GetMapping("/xsede-reparacion/{empresaid}/{sedeid}/{estado}/{enreparacion}")
    public List<CamionesModel> GetCamEmpSedeRep(@PathVariable Long empresaid, @PathVariable Long sedeid, @PathVariable Boolean estado, @PathVariable Boolean enreparacion){
        EmpresasModel empresa = new EmpresasModel();
        empresa.setId(empresaid);

        SedesModel sedes = new SedesModel();
        sedes.setId(sedeid);

        return camionesService.ListarxEmpresaxSedexEstadoxReparacion(empresa, sedes, estado, enreparacion);
    }

    //CRUD
    @GetMapping
    public List<CamionesModel> findAll(){
        return camionesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CamionesModel> findById(@PathVariable Long id){
        Optional<CamionesModel> camion = camionesService.findById(id);
        if (camion.isPresent()){
            return new ResponseEntity<>(camion.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CamionesModel> createCamion(@RequestBody CamionesModel camionesModel){
        CamionesModel ccamion = camionesService.createCamion(camionesModel);
        return new ResponseEntity<>(ccamion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CamionesModel> editCamion(@RequestBody CamionesModel camionesModel, @PathVariable Long id){
        CamionesModel ecamion = camionesService.editCamion(camionesModel, id);
        if(ecamion!=null){
            return new ResponseEntity<>(ecamion, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CamionesModel> deleteCamion(@PathVariable Long id){
        camionesService.deleteCamion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
