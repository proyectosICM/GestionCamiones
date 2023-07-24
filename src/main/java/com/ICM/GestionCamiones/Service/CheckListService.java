package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.CamionesModel;
import com.ICM.GestionCamiones.Models.CheckListModel;
import com.ICM.GestionCamiones.Repositories.CheckListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckListService {
    @Autowired
    CheckListRepository checkListRepository;
    public Optional<CheckListModel> Listarxid(Long id){
        return checkListRepository.findById(id);
    }
    public List<CheckListModel> ListarxCamion(Long id){
        CamionesModel camionesModel = new CamionesModel();
        camionesModel.setId(id);
        return checkListRepository.findByCamionesModel(camionesModel);
    }
}
