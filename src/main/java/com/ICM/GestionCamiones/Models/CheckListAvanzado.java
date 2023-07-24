package com.ICM.GestionCamiones.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CheckListAvanzado")
public class CheckListAvanzado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //Cabina
    private Boolean pruebaArranque;
    private Boolean funcionamientoTablero;
    private Boolean presionFrenos;
    private Boolean cargaAlternador;
    private Boolean frenoMotor;
    private Boolean giroTimon;
    private Boolean tensionEmbrague;
    private Boolean funcionamientoClaxon;
    private Boolean alarmaRetroceso;
    private Boolean cinturonSeguridad;
    private Boolean espejosLunas;
    private Boolean estadoVidrios;
    private Boolean baseEspejo;
    private Boolean funcionamientoChapas;
    private Boolean filtroAire;

    //Compartimiento del Motor
    private Boolean fajaVentilador;
    private Boolean nivelAceite;
    private Boolean nivelRefrigerante;
    private Boolean nivelFluidoCajaD;
    private Boolean filtroAireMotor;
    private Boolean filtroSeparadorCombustible;
    private Boolean holguraDireccion;
    private Boolean ductoAdmision;
    private Boolean ductoEscape;
    private Boolean presionAire;
    private Boolean vidaBateria;
    private Boolean filtroRecirculacionAire;
    private Boolean estanqueidadMotor;
    private Boolean filtroAceiteMotor;

}
