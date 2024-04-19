package com.ICM.GestionCamiones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CheckListExpresoCarreta")
public class ChecklistExpresoCarretaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "camion", referencedColumnName = "id", nullable = false)
    private CamionesModel camionesModel;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    private UsuariosModel usuariosModel;

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
}
