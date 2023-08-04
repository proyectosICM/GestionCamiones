package com.ICM.GestionCamiones.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RegistroGeneralSalidas")
public class RGS_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clcamcond", referencedColumnName = "id", nullable = false)
    private CheckListCamionModel checkListCamionModel;

    @ManyToOne
    @JoinColumn(name = "clcarrcond", referencedColumnName = "id", nullable = true)
    private CheckListCarretaModel checkListCarretaModel;
}