package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.CheckListCamionModel;
import com.ICM.GestionCamiones.Models.CheckListCarretaModel;
import com.ICM.GestionCamiones.Repositories.CheckListCarretaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckListCarretaService {
    @Autowired
    CheckListCarretaRepository checkListCarretaRepository;

    public List<CheckListCarretaModel> GetAllChecklistCarreta(){
        return checkListCarretaRepository.findAll();
    }

    public Optional<CheckListCarretaModel> GetById(Long id){
        return checkListCarretaRepository.findById(id);
    }

    public CheckListCarretaModel CreateCLCarreta(CheckListCarretaModel checkListCarretaModel){
        return checkListCarretaRepository.save(checkListCarretaModel);
    }
}
