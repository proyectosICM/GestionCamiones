package com.ICM.GestionCamiones.controllers;

import com.ICM.GestionCamiones.models.EmpresasModel;
import com.ICM.GestionCamiones.models.FallasImagen_Model;
import com.ICM.GestionCamiones.service.EmpresasService;
import com.ICM.GestionCamiones.service.FallasImagen_Service;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.nio.file.Paths;

import java.nio.file.Files;
import java.util.stream.Collectors;



import org.springframework.core.io.ByteArrayResource;

import org.springframework.http.MediaType;


@RestController
@RequestMapping("api/fallas-imagen")
public class FallasImagen_Controller {
    @Autowired
    FallasImagen_Service fallasImagenService;

    @Autowired
    EmpresasService empresasService;

    @Value("${file.image}")
    private String pathimg;

    //CRUD
    @GetMapping
    public List<FallasImagen_Model> findAll(){
        return fallasImagenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FallasImagen_Model> findById(@PathVariable Long id){
        Optional<FallasImagen_Model> fallasImagen = fallasImagenService.findById(id);
    return new ResponseEntity<>(fallasImagen.get(), HttpStatus.OK);
    }



    @GetMapping("/AllNamesimages")
    public ResponseEntity<?> findByEmpresaModelIdAndCheckListCamionModelIdOrCheckListCarretaModelId(
            @RequestParam Long empresaId,
            @RequestParam String dt,
            @RequestParam Long dato1,
            @RequestParam Long dato2
    ) {
        try {
            List<?> result = fallasImagenService.findByEmpresaModelIdAndCheckListCamionModelIdOrCheckListCarretaModelId(empresaId, dt, dato1, dato2);
            Optional<?> empresaData = empresasService.findById(empresaId);


            // Convertir la lista de objetos FallasImagen_Model a una lista de nombres de imágenes

            List<String> imageNames = result.stream()
                    .map(obj -> {
                        if (obj instanceof FallasImagen_Model) {
                            FallasImagen_Model imagen = (FallasImagen_Model) obj;
                            return imagen.getUrlImage();
                        } else {
                            return null; // O manejar de otra manera si se espera otro tipo de objeto
                        }
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok(imageNames);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error en el servidor.");
        }
    }

    @GetMapping("/images")
    public ResponseEntity<Resource> serveImage(@RequestParam String filename, @RequestParam Long company) {
        try {
            Optional<EmpresasModel> companyModel = empresasService.findById(company);
            // Construir la ruta personalizada usando los parámetros company e irregularity
            String fullPath = pathimg + "/" + companyModel.get().getNombre() + "/" + filename;

            // Crear un Path a partir de la ruta completa
            Path file = Paths.get(fullPath);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_PNG)
                        .body(resource);
            } else {
                throw new RuntimeException("No se pudo leer el archivo: " + fullPath);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }


    @PostMapping("/guardar-imagen")
    public ResponseEntity<String> guardarImagen(@RequestParam("file") MultipartFile file, @RequestParam("empresaId") Long empresaId,
                                                @RequestParam("camionId") Long camionId) {
        try {
            String fileName = fallasImagenService.saveImage(file, empresaId, camionId);
            return ResponseEntity.ok(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la imagen.");
        }
    }


    @PostMapping
    public ResponseEntity<FallasImagen_Model> createErrorImage(@RequestBody FallasImagen_Model fallasImagenModel){
        FallasImagen_Model cfallasImagen = fallasImagenService.createErrorImage(fallasImagenModel);
        return new ResponseEntity<>(cfallasImagen, HttpStatus.CREATED);
    }
}
