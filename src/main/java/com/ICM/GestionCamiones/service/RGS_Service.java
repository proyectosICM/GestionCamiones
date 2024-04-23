package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.*;
import com.ICM.GestionCamiones.repositories.CamionesRepository;
import com.ICM.GestionCamiones.repositories.CheckListCamionRepository;
import com.ICM.GestionCamiones.repositories.RGS_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
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

    @Autowired
    FallasImagen_Service fallasImagenService;

    public List<RGSModel> findAll() {
        return rgsRepository.findAll();
    }

    public Optional<RGSModel> findById(Long id) {
        return rgsRepository.findById(id);
    }

    public Optional<RGSModel> findByUsuariosModelIdAndEnUso(Long usuarioId, Boolean enUso) {
        return rgsRepository.findByUsuariosModelIdAndEnUso(usuarioId, enUso);
    }

    public Page<RGSModel> findByCheckListCamionModelCamionesModelId(Long camionId, Pageable pageable) {
        Optional<CamionesModel> vehicleData = camionesRepository.findById(camionId);
        if (vehicleData.isPresent()) {
            if (vehicleData.get().getTiposCModel().getId() == 1L) {
                return rgsRepository.findByCheckListCamionModelCamionesModelIdOrderByUpdatedAtDesc(camionId, pageable);
            } else if (vehicleData.get().getTiposCModel().getId() == 2L) {
                return rgsRepository.findByCheckListCarretaModelCamionesModelIdOrderByUpdatedAtDesc(camionId, pageable);
            }
        }
        throw new RuntimeException("No se encontró un vehículo con el ID especificado: " + camionId);
    }

    public RGSModel createRGS(RGSModel rgs) {
        Optional<RGSModel> existingRGS = findByUsuariosModelIdAndEnUso(rgs.getUsuariosModel().getId(), true);
        // Optional<FallasImagen_Model> fallas =
        if (existingRGS.isPresent()) {
            // Cambiar el estado de enUso del RGS existente a false
            existingRGS.get().setEnUso(false);
            fallasImagenService.editclImage(rgs.getCheckListCamionModel().getId(), rgs.getCheckListCarretaModel().getId());
            rgsRepository.save(existingRGS.get());
        }
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
