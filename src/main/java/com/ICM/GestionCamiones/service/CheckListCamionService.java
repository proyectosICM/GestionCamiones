package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.CamionesModel;
import com.ICM.GestionCamiones.models.CheckListCamionModel;
import com.ICM.GestionCamiones.repositories.CheckListCamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckListCamionService {
    @Autowired
    CheckListCamionRepository checkListCamionRepository;

    public List<CheckListCamionModel> ListarxCamion(Long id){
        CamionesModel camionesModel = new CamionesModel();
        camionesModel.setId(id);
        return checkListCamionRepository.findByCamionesModel(camionesModel);
    }
    public List<CheckListCamionModel> findByCamionesModelEmpresasModelId(Long id) {
        return checkListCamionRepository.findByCamionesModelEmpresasModelId(id);
    }
    //CRUD
    public List<CheckListCamionModel> GetAllCheckLists(){
        return checkListCamionRepository.findAll();
    }

    public Optional<CheckListCamionModel> Listarxid(Long id){
        return checkListCamionRepository.findById(id);
    }

    public CheckListCamionModel GuardarCheckList(CheckListCamionModel checkListCamionModel){
        return checkListCamionRepository.save(checkListCamionModel);
    }
}
