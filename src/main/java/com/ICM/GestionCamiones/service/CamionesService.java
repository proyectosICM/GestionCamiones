package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.CamionesModel;
import com.ICM.GestionCamiones.models.EmpresasModel;
import com.ICM.GestionCamiones.models.SedesModel;
import com.ICM.GestionCamiones.repositories.CamionesRepository;
import com.ICM.GestionCamiones.utils.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class CamionesService {
    @Autowired
    CamionesRepository camionesRepository;

    @Autowired
    private DirectoryService directoryService;

    public Page<CamionesModel> findByEmpresasModelIdAndSedesModelIdAndEstado(Long empresasId, Long sedesId, Boolean estado, Pageable pageable) {
        return camionesRepository.findByEmpresasModelIdAndSedesModelIdAndEstado(empresasId, sedesId, estado, pageable);
    }

    public Page<CamionesModel> findByEmpresasModelIdAndSedesModelIdAndEstadoAndTiposCModelId(Long empresasId, Long sedesId, Boolean estado, Long tiposCId,Pageable pageable) {
        return camionesRepository.findByEmpresasModelIdAndSedesModelIdAndEstadoAndTiposCModelId(empresasId, sedesId, estado, tiposCId, pageable);
    }

    public List<CamionesModel>ListarCamionesxEmpresaEst(EmpresasModel empresasModel, Boolean estado){
        return camionesRepository.findByEmpresasModelAndEstado(empresasModel, estado);
    }

    public List<CamionesModel>ListarxEmpresaxSedexEstado(EmpresasModel empresasModel, SedesModel sedesModel, Boolean estado){
        return camionesRepository.findByEmpresasModelAndSedesModelAndEstado(empresasModel, sedesModel, estado);
    }

    public List<CamionesModel>ListarxEmpresaxSedexEstadoxReparacion(EmpresasModel empresasModel, SedesModel sedesModel, Boolean estado, Boolean enreparacion){
        return camionesRepository.findByEmpresasModelAndSedesModelAndEstadoAndEnreparacion(empresasModel, sedesModel, estado, enreparacion);
    }
    // CRUD
    public List<CamionesModel> findAll(){
        return camionesRepository.findAll();
    }

    public Optional<CamionesModel> findById(Long id){
        return camionesRepository.findById(id);
    }

    public CamionesModel createCamion(CamionesModel camionesModel) {
        Optional<CamionesModel> existingCamion = camionesRepository.findByPlaca(camionesModel.getPlaca());

        if (existingCamion.isPresent()) {
            throw new RuntimeException("Ya existe un camión con la misma placa");
        }
        directoryService.createDirectoryWithName(camionesModel.getEmpresasModel().getNombre()
                + File.separator + camionesModel.getPlaca() );
        return camionesRepository.save(camionesModel);
    }

    public CamionesModel editCamion(CamionesModel camionesModel, Long id){
        Optional<CamionesModel> existing = camionesRepository.findById(id);
        if(existing.isPresent()){
            CamionesModel camiones = existing.get();
            camiones.setPlaca(camionesModel.getPlaca());
            camiones.setTiposCModel(camionesModel.getTiposCModel());
            camiones.setMarcasModel(camionesModel.getMarcasModel());
            camiones.setModeloModel(camionesModel.getModeloModel());
            camiones.setSedesModel(camionesModel.getSedesModel());
            return camionesRepository.save(camiones);
        }
        return null;
    }
    public void deleteCamion(Long id){
        camionesRepository.deleteById(id);
    }

}
