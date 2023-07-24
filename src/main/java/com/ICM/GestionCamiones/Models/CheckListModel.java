package com.ICM.GestionCamiones.Models;

import com.ICM.GestionCamiones.Models.CheckList.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CheckList")
public class CheckListModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    // Llantas
    @ManyToOne
    @JoinColumn(name = "Llantas", referencedColumnName = "id", nullable = false)
    private Llantas llantas;

    //Motor
    @ManyToOne
    @JoinColumn(name = "Motor", referencedColumnName = "id", nullable = false)
    private Motor motor;

    // Sistema Electrico
    @ManyToOne
    @JoinColumn(name = "Sistemaelectrico", referencedColumnName = "id", nullable = false)
    private SistemaElectrico sistemaElectrico;

    //Transmision
    @ManyToOne
    @JoinColumn(name = "Transmision", referencedColumnName = "id", nullable = false)
    private Transmision transmision ;

    // Direccion
    @ManyToOne
    @JoinColumn(name = "Direccion", referencedColumnName = "id", nullable = false)
    private Direccion direccion;


    // Frenos
    @ManyToOne
    @JoinColumn(name = "Frenos", referencedColumnName = "id", nullable = false)
    private Frenos frenos;

    // Suspension
    @ManyToOne
    @JoinColumn(name = "Suspension", referencedColumnName = "id", nullable = false)
    private Suspension suspension;


    // Cabina
    @ManyToOne
    @JoinColumn(name = "Cabina", referencedColumnName = "id", nullable = false)
    private Cabina cabina;
    // Camion
    @ManyToOne
    @JoinColumn(name = "Camion", referencedColumnName = "id", nullable = false)
    private CamionesModel camionesModel;
}
