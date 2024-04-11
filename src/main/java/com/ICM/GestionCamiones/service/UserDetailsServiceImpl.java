package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.UsuariosModel;
import com.ICM.GestionCamiones.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuariosModel usuariosModel = usuariosRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe"));

        Collection<? extends GrantedAuthority> authorities = usuariosModel.getRolesModel() != null ?
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + usuariosModel.getRolesModel().getNombre())) :
                null;


        return new User(
                usuariosModel.getUsername(),
                usuariosModel.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
    }
}