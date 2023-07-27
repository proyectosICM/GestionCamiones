package com.ICM.GestionCamiones.Service;

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
    public Optional<UsuariosModel> ListarInfo(String username){
        return usuariosRepository.findByUsername(username);
    }
    //CRUD

    public List<UsuariosModel> GetUsers(){
        return usuariosRepository.findAll();
    }

    public Optional<UsuariosModel> GetUserId(Long id){
        return usuariosRepository.findById(id);
    }

    public UsuariosModel CreateUser(UsuariosModel usuariosModel){
        return usuariosRepository.save(usuariosModel);
    }

    public UsuariosModel EditUser(UsuariosModel usuariosModel, Long id){
        Optional<UsuariosModel> existing = usuariosRepository.findById(id);
        if (existing.isPresent()){
            UsuariosModel usuario = existing.get();
            usuario.setUsername(usuariosModel.getUsername());
            usuario.setPassword(usuariosModel.getPassword());
            usuario.setNombre(usuariosModel.getNombre());
            usuario.setApellido(usuariosModel.getApellido());
            usuario.setRolesModel(usuariosModel.getRolesModel());
            usuario.setSedesModel(usuariosModel.getSedesModel());
            return usuariosRepository.save(usuario);
        }
        return null;
    }

    public void DeleteUser(Long id){
        usuariosRepository.deleteById(id);
    }
}
