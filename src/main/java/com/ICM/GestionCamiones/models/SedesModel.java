package com.ICM.GestionCamiones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Sedes")
public class SedesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "empresa", referencedColumnName = "id", nullable = false)
    private EmpresasModel empresasModel;
}
