package com.ICM.GestionCamiones.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RegistroGeneralSalidas")
public class RGSModel {
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

    @ManyToOne
    @JoinColumn(name = "clexpreso", referencedColumnName = "id", nullable = true)
    private CheckListExpresoModel checkListExpresoModel;

    @Column(nullable = false)
    private Boolean estado;

    @Column(nullable = false)
    private Boolean reparacion;

    @Column(nullable = true)
    private Integer kilometrajeCamion;
    @Column(nullable = true)
    private Integer kilometrajeCarreta;
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "sede", referencedColumnName = "id", nullable = false)
    private SedesModel sedesModel;

    @ManyToOne
    @JoinColumn(name = "empresa", referencedColumnName = "id", nullable = false)
    private EmpresasModel empresasModel;
}
