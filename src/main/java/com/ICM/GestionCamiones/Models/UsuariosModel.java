package com.ICM.GestionCamiones.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuarios")
public class UsuariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String username;
    private String password;
    private String nombre;
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "rol", referencedColumnName = "id", nullable = false)
    private RolesModel rolesModel;
}
