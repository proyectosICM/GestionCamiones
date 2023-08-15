package com.ICM.GestionCamiones;

import com.ICM.GestionCamiones.Models.EmpresasModel;
import com.ICM.GestionCamiones.Models.RolesModel;
import com.ICM.GestionCamiones.Models.SedesModel;
import com.ICM.GestionCamiones.Models.UsuariosModel;
import com.ICM.GestionCamiones.Repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GestionCamionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionCamionesApplication.class, args);
	}
/*
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UsuariosRepository usuariosRepository;

	@Bean
	CommandLineRunner init() {
		return args -> {
			EmpresasModel empresa = new EmpresasModel();
			empresa.setId(1L);

			RolesModel rol = new RolesModel();
			rol.setId(1L);

			SedesModel sede = new SedesModel();
			sede.setId(1L);

			UsuariosModel usuariosModel  = UsuariosModel.builder()
					.nombre("Eduardo")
					.apellido("Aguilar")
					.username("cond3")
					.password(passwordEncoder.encode("1234"))
					.rolesModel(rol)
					.empresasModel(empresa)
					.sedesModel(sede)
					.build();
			usuariosRepository.save(usuariosModel);
		};
	}*/
}
