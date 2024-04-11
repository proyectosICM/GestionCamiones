package com.ICM.GestionCamiones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ObservacionesRGS")
public class ObservacionesRGSModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nameObs;

    @ManyToOne
    @JoinColumn(name = "rgs", referencedColumnName = "id", nullable = false)
    private RGSModel rgsModel;
}
