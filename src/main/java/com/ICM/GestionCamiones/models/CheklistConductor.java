package com.ICM.GestionCamiones.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CheckList")
public class CheklistConductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Camion", referencedColumnName = "id", nullable = false)
    private CamionesModel camionesModel;
    // Llantas
    private Boolean RevisarAjuste;
    private Boolean CortesYAverias;
    private Boolean RevisarPresionRecomendada;
    //Motor
    private Boolean NivelesDeMotor;
    private Boolean SistemaDeLubricacionDeFugas;
    private Boolean SistemaDeCombustible;

    // Sistema Electrico
    private Boolean  Luces;
    private Boolean SistemaDeCarga;
    private Boolean MandosTablero;
    private Boolean SistemaDeArranque;
    private Boolean RuidosAnormalesSE;
    private Boolean OtrosEquiposElectricos;

    //Transmision
    private Boolean Embrague;
    private Boolean CajaDeCambio;
    private Boolean Diferencial;
    private Boolean Cardanes;
    private Boolean RuidosAnormalesT;

    // Direccion
    private Boolean Seryo;
    private Boolean Alineamiento;
    private Boolean PinesBocinasTerminales;
    private Boolean CajaDeDirecion;

    // Frenos
    private Boolean LimpiezaYRegulacion;
    private Boolean PresionDeAire;
    private Boolean FrenoDeEstacionamiento;

    // Suspension
    private Boolean Muelles, BolsasDeAire;
    private Boolean Amortiguadores;
    private Boolean EjesBarraEstabilizadora;

    // Cabina
    private Boolean Carroceria;
    private Boolean Chasis;
}
