package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.CamionesModel;
import com.ICM.GestionCamiones.Models.EmpresasModel;
import com.ICM.GestionCamiones.Models.SedesModel;
import com.ICM.GestionCamiones.Service.CamionesService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CamionesModel> GetAllCamiones(){
        return camionesService.GetCamion();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CamionesModel> GetIdCamion(@PathVariable Long id){
        Optional<CamionesModel> camion = camionesService.GetCamionId(id);
        if (camion.isPresent()){
            return new ResponseEntity<>(camion.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CamionesModel> CreateCamion(@RequestBody CamionesModel camionesModel){
        CamionesModel ccamion = camionesService.CreateCamion(camionesModel);
        return new ResponseEntity<>(ccamion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CamionesModel> EditCamion(@RequestBody CamionesModel camionesModel, @PathVariable Long id){
        CamionesModel ecamion = camionesService.EditCamion(camionesModel, id);
        if(ecamion!=null){
            return new ResponseEntity<>(ecamion, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CamionesModel> DeleteCamion(@PathVariable Long id){
        camionesService.DeleteCamion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
