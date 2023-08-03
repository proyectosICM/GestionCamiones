package com.ICM.GestionCamiones.Models;

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

    @ManyToOne
    @JoinColumn(name = "camion", referencedColumnName = "id", nullable = false)
    private CamionesModel camionesModel;

    private String nroLlanta;
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "cambioLlantas", referencedColumnName = "id", nullable = false)
    private RGS_Model rgsModel;
}
