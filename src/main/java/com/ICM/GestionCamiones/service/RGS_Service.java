package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.*;
import com.ICM.GestionCamiones.repositories.CamionesRepository;
import com.ICM.GestionCamiones.repositories.CheckListCamionRepository;
import com.ICM.GestionCamiones.repositories.RGS_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<RGSModel> findAll() {
        return rgsRepository.findAll();
    }

    public Optional<RGSModel> findById(Long id) {
        return rgsRepository.findById(id);
    }

    public RGSModel createRGS(RGSModel rgs) {
        return rgsRepository.save(rgs);
    }

    public RGSModel updateRGS(Long id, RGSModel updatedRGS) {
        if (rgsRepository.existsById(id)) {
            updatedRGS.setId(id); // Ensure the ID is set for update
            return rgsRepository.save(updatedRGS);
        } else {
            // Handle error or throw exception
            return null;
        }
    }

    public void deleteRGS(Long id) {
        rgsRepository.deleteById(id);
    }
}
