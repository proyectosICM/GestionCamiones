package com.ICM.GestionCamiones.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CheckCarreta")
public class CheckListCarretaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //Llantas
    private Boolean RevisarAjuste;
    private Boolean CortesYAverias;
    private Boolean RevisarPresionRecomendada;

    //Semi-remolque
    private Boolean nivelesBolsaDeAire;
    private Boolean templadoresBocinas;
    private Boolean planca;
    private Boolean sistemaFreno;
    private Boolean sistemaElectrico;
    private Boolean bocamasas;
    private Boolean manguera;
    private Boolean chasis;
    private Boolean cortinasPuertasMamparon;
    private Boolean furgo;

    // Camion
    @ManyToOne
    @JoinColumn(name = "Camion", referencedColumnName = "id", nullable = false)
    private CamionesModel camionesModel;

    private Integer tiempo;
}
