package com.ICM.GestionCamiones.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuarios")
public class UsuariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String nombre;
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "rol", referencedColumnName = "id", nullable = false)
    private RolesModel rolesModel;

    @ManyToOne
    @JoinColumn(name = "empresa", referencedColumnName = "id", nullable = false)
    private EmpresasModel empresasModel;

    @ManyToOne
    @JoinColumn(name = "sede", referencedColumnName = "id", nullable = false)
    private SedesModel sedesModel;

/*
    @ManyToOne
    @JoinColumn(name = "rgs", referencedColumnName = "id", nullable = true)
    private RGSModel rgsModel;
*/

}
