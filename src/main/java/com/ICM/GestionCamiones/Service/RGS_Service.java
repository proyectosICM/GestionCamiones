package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.*;
import com.ICM.GestionCamiones.Repositories.CamionesRepository;
import com.ICM.GestionCamiones.Repositories.CheckListCamionRepository;
import com.ICM.GestionCamiones.Repositories.RGS_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RGS_Service {
    @Autowired
    RGS_Repository rgsRepository;

    @Autowired
    CheckListCamionRepository checkListCamionRepository;

    @Autowired
    CamionesRepository camionesRepository;
/*
    public List<RGS_Model> getxEmpresaAndxSede(Long empresaid, Long sedeid, Boolean estado) {
        // Obtener el objeto Empresa y Sede por sus IDs
        EmpresasModel empresa = new EmpresasModel();
        empresa.setId(empresaid);

        SedesModel sede = new SedesModel();
        sede.setId(sedeid);

        // Obtener la lista de objetos CamionesModel por empresa, sede y estado
        List<CamionesModel> camionesModelList = camionesRepository.findByEmpresasModelAndSedesModelAndEstado(empresa, sede, estado);

        // Crear una lista para almacenar los resultados de RGS_Model
        List<RGS_Model> rgsModelList = new ArrayList<>();

        // Iterar sobre la lista de camionesModel y obtener los resultados de RGS_Model para cada camión
        for (CamionesModel camionesModel : camionesModelList) {
            // Realizar la consulta utilizando el objeto CamionesModel directamente
            CheckListCamionModel cls  = new CheckListCamionModel();
            cls.getCamionesModel().setSedesModel(sede);
            cls.getCamionesModel().setEmpresasModel(empresa);
            cls.getCamionesModel().setEstado(estado);
            List<RGS_Model> rgsResult = rgsRepository.findByCheckListCamionModel(cls);
            rgsModelList.addAll(rgsResult);
        }

        return rgsModelList;
    }
    */

    public List<RGS_Model> getxEmpresaAndxSede(Long empresaid, Long sedeid, Boolean estado) {
        return rgsRepository.findByCheckListCamionModel_CamionesModel_EmpresasModel_IdAndCheckListCamionModel_CamionesModel_SedesModel_IdAndCheckListCamionModel_CamionesModel_Estado(empresaid, sedeid, estado);
    }

    //CRUD

    public List<RGS_Model> getAllRgsModel() {
        return rgsRepository.findAll();
    }

    public Optional<RGS_Model> getIdRgs(Long id){
        return rgsRepository.findById(id);
    }

    public RGS_Model saveRgs(RGS_Model rgsModel){
        return rgsRepository.save(rgsModel);
    }

}
