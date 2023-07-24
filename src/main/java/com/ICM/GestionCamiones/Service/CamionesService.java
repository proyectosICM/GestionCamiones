package com.ICM.GestionCamiones.Service;

import com.ICM.GestionCamiones.Models.CamionesModel;
import com.ICM.GestionCamiones.Models.EmpresasModel;
import com.ICM.GestionCamiones.Repositories.CamionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamionesService {
    @Autowired
    CamionesRepository camionesRepository;

    public List<CamionesModel>ListarCamionesxEmpresaEst(EmpresasModel empresasModel, Boolean estado){
        return camionesRepository.findByEmpresasModelAndEstado(empresasModel, estado);
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
