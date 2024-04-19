package com.ICM.GestionCamiones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZoneId;
import java.time.ZonedDateTime;

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
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    private UsuariosModel usuariosModel;

    //(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "camioncl", referencedColumnName = "id", nullable = false)
    private CheckListCamionModel checkListCamionModel;

    @ManyToOne
    @JoinColumn(name = "carretacl", referencedColumnName = "id", nullable = false)
    private CheckListCarretaModel checkListCarretaModel;

    @ManyToOne
    @JoinColumn(name = "sede", referencedColumnName = "id", nullable = false)
    private SedesModel sedesModel;

    @ManyToOne
    @JoinColumn(name = "empresa", referencedColumnName = "id", nullable = false)
    private EmpresasModel empresasModel;

    private Boolean enUso;

    /**
     * Timestamps for recording the creation and last update times of the record.
     * - 'createdAt' is set at the time of creation and is not updatable.
     * - 'updatedAt' is set at the time of creation and updated on every modification to the record.
     */
    @Column(name = "createdat", nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt = ZonedDateTime.now(ZoneId.of("America/Lima"));

    @Column(name = "updatedAt")
    @UpdateTimestamp
    private ZonedDateTime updatedAt = ZonedDateTime.now(ZoneId.of("America/Lima"));
}
