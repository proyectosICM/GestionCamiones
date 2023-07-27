package com.ICM.GestionCamiones.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Camiones")
public class CamionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String placa;
    private Boolean estado;
    private Boolean enreparacion;

    @ManyToOne
    @JoinColumn(name = "tipoc", referencedColumnName = "id", nullable = false)
    private TiposCModel tiposCModel;

    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "id", nullable = false)
    private MarcasModel marcasModel;

    @ManyToOne
    @JoinColumn(name = "modelo", referencedColumnName = "id", nullable = false)
    private ModelosModel modeloModel;

    @ManyToOne
    @JoinColumn(name = "sede", referencedColumnName = "id", nullable = false)
    private SedesModel sedesModel;

    @ManyToOne
    @JoinColumn(name = "empresa", referencedColumnName = "id", nullable = false)
    private EmpresasModel empresasModel;
}
