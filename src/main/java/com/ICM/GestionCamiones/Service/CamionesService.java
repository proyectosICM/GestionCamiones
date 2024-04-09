package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.CamionesModel;
import com.ICM.GestionCamiones.Models.EmpresasModel;
import com.ICM.GestionCamiones.Models.SedesModel;
import com.ICM.GestionCamiones.Repositories.CamionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamionesService {
    @Autowired
    CamionesRepository camionesRepository;

    public Page<CamionesModel> findByEmpresasModelIdAndSedesModelIdAndEstado(Long empresasId, Long sedesId, Boolean estado, Pageable pageable) {
        return camionesRepository.findByEmpresasModelIdAndSedesModelIdAndEstado(empresasId, sedesId, estado, pageable);
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
    public List<CamionesModel> GetCamion(){
        return camionesRepository.findAll();
    }

    public Optional<CamionesModel> GetCamionId(Long id){
        return camionesRepository.findById(id);
    }

    public CamionesModel CreateCamion(CamionesModel camionesModel){
        return camionesRepository.save(camionesModel);
    }

    public CamionesModel EditCamion(CamionesModel camionesModel, Long id){
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
    public void DeleteCamion(Long id){
        camionesRepository.deleteById(id);
    }

}
