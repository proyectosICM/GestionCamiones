package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.ChecklistExpresoCamionModel;
import com.ICM.GestionCamiones.models.ChecklistExpresoCarretaModel;
import com.ICM.GestionCamiones.repositories.CheckListExpresoCamionRepository;
import com.ICM.GestionCamiones.repositories.ChecklistExpresoCarretaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChecklistExpresoCarretaService {
    @Autowired
    ChecklistExpresoCarretaRepository checklistExpresoCarretaRepository;

    public List<ChecklistExpresoCarretaModel> GetAllCle(){
        return checklistExpresoCarretaRepository.findAll();
    }
    public Page<ChecklistExpresoCarretaModel> findByCamionesModelId(Long camionesId, Pageable pageable) {
        return checklistExpresoCarretaRepository.findByCamionesModelId(camionesId, pageable);
    }

    public Optional<ChecklistExpresoCarretaModel> GetByIdCle(Long id){
        return checklistExpresoCarretaRepository.findById(id);
    }

    public ChecklistExpresoCarretaModel CreateCle(ChecklistExpresoCarretaModel checklistExpresoCarretaModel){
        return checklistExpresoCarretaRepository.save(checklistExpresoCarretaModel);
    }
}
