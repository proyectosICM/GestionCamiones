package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.CheckListCarretaModel;
import com.ICM.GestionCamiones.repositories.CheckListCarretaRepository;
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
    public List<CheckListCarretaModel> findByCamionesModelEmpresasModelId(Long id) {
        return checkListCarretaRepository.findByCamionesModelEmpresasModelId(id);
    }

    public Optional<CheckListCarretaModel> GetById(Long id){
        return checkListCarretaRepository.findById(id);
    }

    public CheckListCarretaModel CreateCLCarreta(CheckListCarretaModel checkListCarretaModel){
        return checkListCarretaRepository.save(checkListCarretaModel);
    }
}
