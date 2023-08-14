package com.ICM.GestionCamiones.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reparaciones")
public class ReparacionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String titulo;
    private String urlImage;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    private UsuariosModel usuariosModel;

    @ManyToOne
    @JoinColumn(name = "RGS", referencedColumnName = "id", nullable = true)
    private RGSModel rgsModel;
}
