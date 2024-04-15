package com.ICM.GestionCamiones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FallasImagen")
public class FallasImagen_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String urlImage;

    private String observacion;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    private UsuariosModel usuariosModel;

    @ManyToOne
    @JoinColumn(name = "empresa", referencedColumnName = "id", nullable = false)
    private UsuariosModel empresaModel;

    @ManyToOne
    @JoinColumn(name = "checklistCamion", referencedColumnName = "id", nullable = true)
    private CheckListCamionModel checklistCamion;

    @ManyToOne
    @JoinColumn(name = "checklistCarreta", referencedColumnName = "id", nullable = true)
    private CheckListCarretaModel checkListCarretaModel;


}
