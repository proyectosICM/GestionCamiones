package com.ICM.GestionCamiones.Security;

import com.ICM.GestionCamiones.Models.UsuariosModel;
import com.ICM.GestionCamiones.Repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    @Autowired
    UsuariosRepository usuariosRepository;

    public List<UsuariosModel> ListarUsuarios(){
        return usuariosRepository.findAll();
    }

    public Optional<UsuariosModel> ListarUsuarioId(Long id){
        return usuariosRepository.findById(id);
    }

    public UsuariosModel CrearUsuario(UsuariosModel usuariosModel){
        return usuariosRepository.save(usuariosModel);
    }

    public UsuariosModel EditarUsuario(UsuariosModel usuariosModel, Long id){
        Optional<UsuariosModel> existing = usuariosRepository.findById(id);
        if (existing.isPresent()){
            UsuariosModel usuario = existing.get();
            usuario.setUsername(usuariosModel.getUsername());
            usuario.setPassword(usuariosModel.getPassword());
            usuario.setNombre(usuariosModel.getNombre());
            usuario.setApellido(usuariosModel.getApellido());
            usuario.setRolesModel(usuariosModel.getRolesModel());
            return usuariosRepository.save(usuario);
        }
        return null;
    }

    public void EliminarUsuario(Long id){
        usuariosRepository.deleteById(id);
    }
}
