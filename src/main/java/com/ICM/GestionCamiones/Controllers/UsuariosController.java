package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.UsuariosModel;
import com.ICM.GestionCamiones.Service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {
    @Autowired
    UsuariosService usuariosService;

    @GetMapping("/saludo")
    public String Hola(){
        return "Holamundo";
    }
    @GetMapping("/info/{username}")
    public ResponseEntity<UsuariosModel> infoTra(@PathVariable("username") String username){
        Optional<UsuariosModel> trabajadores = usuariosService.ListarInfo(username);
        if (trabajadores.isPresent()){
            return new ResponseEntity<>(trabajadores.get(), HttpStatus.OK);
        }
        return null;
    }

    //CRUD
    @GetMapping
    public List<UsuariosModel> GetAllUser(){
        return usuariosService.GetUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosModel> GetUserId(@PathVariable Long id){
        Optional<UsuariosModel> user = usuariosService.GetUserId(id);
        if (user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<UsuariosModel> CreateUser(@RequestBody UsuariosModel usuariosModel){
        UsuariosModel cuser = usuariosService.CreateUser(usuariosModel);
        return new ResponseEntity<>(cuser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuariosModel> EditUser(@RequestBody UsuariosModel usuariosModel, @PathVariable Long id){
        UsuariosModel euser = usuariosService.EditUser(usuariosModel, id);
        if(euser!=null){
            return new ResponseEntity<>(euser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuariosModel> DeleteUser(@PathVariable Long id){
        usuariosService.DeleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
