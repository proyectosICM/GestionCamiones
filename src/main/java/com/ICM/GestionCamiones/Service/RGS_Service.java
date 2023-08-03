package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.RGS_Model;
import com.ICM.GestionCamiones.Repositories.RGS_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RGS_Service {
    @Autowired
    RGS_Repository rgsRepository;

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
