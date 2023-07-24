package com.ICM.GestionCamiones.Models.CheckList;

import com.ICM.GestionCamiones.Models.CamionesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Sistemaelectrico")
public class SistemaElectrico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Boolean  Luces;
    private Boolean SistemaDeCarga;
    private Boolean MandosTablero;
    private Boolean SistemaDeArranque;
    private Boolean RuidosAnormalesSE;
    private Boolean OtrosEquiposElectricos;

    @ManyToOne
    @JoinColumn(name = "Camion", referencedColumnName = "id", nullable = false)
    private CamionesModel camionesModel;
}
