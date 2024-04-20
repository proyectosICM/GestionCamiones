package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.CheckListCarretaModel;
import com.ICM.GestionCamiones.models.ChecklistExpresoCamionModel;
import com.ICM.GestionCamiones.repositories.CheckListExpresoCamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckListExpresoCamionService {
    @Autowired
    CheckListExpresoCamionRepository checkListExpresoCamionRepository;

    public List<ChecklistExpresoCamionModel> GetAllCle(){
        return checkListExpresoCamionRepository.findAll();
    }

    public List<ChecklistExpresoCamionModel> findByCamionesModelEmpresasModelId(Long id) {
        return checkListExpresoCamionRepository.findByCamionesModelEmpresasModelId(id);
    }

    public Page<ChecklistExpresoCamionModel> findByCamionesModelId(Long camionesId, Pageable pageable) {
        return checkListExpresoCamionRepository.findByCamionesModelId(camionesId, pageable);
    }

    public Optional<ChecklistExpresoCamionModel> GetByIdCle(Long id){
        return checkListExpresoCamionRepository.findById(id);
    }

    public ChecklistExpresoCamionModel CreateCle(ChecklistExpresoCamionModel checklistExpresoCamionModel){
        return checkListExpresoCamionRepository.save(checklistExpresoCamionModel);
    }


}
