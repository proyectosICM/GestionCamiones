package com.ICM.GestionCamiones.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String nombre;
    private String apellido;
    private Long roles;
    private Long empresa;
}
