package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.CheckListExpresoModel;
import com.ICM.GestionCamiones.Repositories.CheckListExpresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckListExpresoService {
    @Autowired
    CheckListExpresoRepository checkListExpresoRepository;

    public List<CheckListExpresoModel> GetAllCle(){
        return checkListExpresoRepository.findAll();
    }

    public Optional<CheckListExpresoModel> GetByIdCle(Long id){
        return checkListExpresoRepository.findById(id);
    }

    public CheckListExpresoModel CreateCle(CheckListExpresoModel checkListExpresoModel){
        return checkListExpresoRepository.save(checkListExpresoModel);
    }


}
