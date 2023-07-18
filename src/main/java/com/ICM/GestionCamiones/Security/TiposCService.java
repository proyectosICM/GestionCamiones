package com.ICM.GestionCamiones.Security;

import com.ICM.GestionCamiones.Models.TiposCModel;
import com.ICM.GestionCamiones.Repositories.TiposCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiposCService {
    @Autowired
    TiposCRepository tiposCRepository;

    public List<TiposCModel> ListarTC(){
        return tiposCRepository.findAll();
    }

    public Optional<TiposCModel> ListarTCId(Long id){
        return tiposCRepository.findById(id);
    }

    public TiposCModel CrearTC(TiposCModel tiposCModel){
        return tiposCRepository.save(tiposCModel);
    }

    public TiposCModel EditarTC(TiposCModel tiposCModel, Long id){
        Optional<TiposCModel> existing = tiposCRepository.findById(id);
        if (existing.isPresent()){
            TiposCModel tipostc = existing.get();
            tipostc.setNombre(tiposCModel.getNombre());
            return tiposCRepository.save(tiposCModel);
        }
        return null;
    }

    public void EliminarTC(Long id){
        tiposCRepository.deleteById(id);
    }
}
