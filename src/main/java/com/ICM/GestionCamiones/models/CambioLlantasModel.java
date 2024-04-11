package com.ICM.GestionCamiones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CambioLlantas")
public class CambioLlantasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nroLlanta;

    private String observacion;

    @ManyToOne
    @JoinColumn(name = "camion", referencedColumnName = "id", nullable = false)
    private CamionesModel camionesModel;

    @ManyToOne
    @JoinColumn(name = "cambioLlantas", referencedColumnName = "id", nullable = false)
    private RGSModel rgsModel;
}
