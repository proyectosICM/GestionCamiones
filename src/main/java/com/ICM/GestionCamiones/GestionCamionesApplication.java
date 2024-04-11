package com.ICM.GestionCamiones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
			sede.setId(3L);

			UsuariosModel usuariosModel  = UsuariosModel.builder()
					.nombre("Eduardo")
					.apellido("Aguilar")
					.username("admin")
					.password(passwordEncoder.encode("1234"))
					.rolesModel(rol)
					.empresasModel(empresa)
					.sedesModel(sede)
					.build();
			usuariosRepository.save(usuariosModel);
		};
	}*/
}
