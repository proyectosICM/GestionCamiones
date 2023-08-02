package com.ICM.GestionCamiones.Models;

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

    @ManyToOne
    @JoinColumn(name = "camion", referencedColumnName = "id", nullable = true)
    private CamionesModel camionesModel;

    @ManyToOne
    @JoinColumn(name = "carreta", referencedColumnName = "id", nullable = true)
    private CamionesModel carreta;
}
