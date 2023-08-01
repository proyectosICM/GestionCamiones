package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.CamionesModel;
import com.ICM.GestionCamiones.Models.CheckListCamionModel;
import com.ICM.GestionCamiones.Repositories.CheckListCamionRepository;
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
