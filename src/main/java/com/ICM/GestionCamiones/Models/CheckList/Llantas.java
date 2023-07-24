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
@Table(name = "Llantas")
public class Llantas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Boolean RevisarAjuste;
    private Boolean CortesYAverias;
    private Boolean RevisarPresionRecomendada;

    @ManyToOne
    @JoinColumn(name = "Camion", referencedColumnName = "id", nullable = false)
    private CamionesModel camionesModel;
}
