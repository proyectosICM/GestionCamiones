package com.ICM.GestionCamiones.service;

import com.ICM.GestionCamiones.models.CamionesModel;
import com.ICM.GestionCamiones.models.EmpresasModel;
import com.ICM.GestionCamiones.models.FallasImagen_Model;
import com.ICM.GestionCamiones.models.RGSModel;
import com.ICM.GestionCamiones.repositories.CamionesRepository;
import com.ICM.GestionCamiones.repositories.EmpresasRepository;
import com.ICM.GestionCamiones.repositories.FallasImagen_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FallasImagen_Service {
    @Autowired
    FallasImagen_Repository fallasImagenRepository;

    @Autowired
    EmpresasRepository empresasRepository;

    @Autowired
    CamionesRepository camionesRepository;

    @Value("${file.image}")
    private String fileImagen;
    //CRUD

    public List<FallasImagen_Model> findAll(){
        return fallasImagenRepository.findAll();
    }

    public Optional<FallasImagen_Model> findById(Long id){
        return fallasImagenRepository.findById(id);
    }

    public String saveImage(MultipartFile file, Long empresaId, Long camionId) throws IOException {
        Optional<EmpresasModel> empresaData = empresasRepository.findById(empresaId);
        Optional<CamionesModel> camionData = camionesRepository.findById(camionId);

        if (empresaData.isPresent() && camionData.isPresent()) {
            // Obtener la extensión del archivo original
            String originalFilename = file.getOriginalFilename();
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));

            // Construir la ruta base del archivo utilizando el nombre de la empresa y la placa del camión
            String basePath = fileImagen + "/" + empresaData.get().getNombre() + "/" + camionData.get().getPlaca() + "/";

            // Verificar si el directorio base existe, si no, crearlo
            File baseDirectory = new File(basePath);
            if (!baseDirectory.exists()) {
                baseDirectory.mkdirs();
            }

            // Generar un nombre de archivo único
            String randomFileName = UUID.randomUUID().toString();

            // Construir la ruta completa del archivo con el nombre aleatorio
            String filePath = basePath + randomFileName + fileExtension;
            File newFile = new File(filePath);

            // Verificar si el archivo ya existe
            int i = 1;
            while (newFile.exists()) {
                // Si el archivo ya existe, generar un nuevo nombre con un sufijo numérico
                randomFileName = UUID.randomUUID().toString();
                filePath = basePath + randomFileName + fileExtension;
                newFile = new File(filePath);
                i++;
            }

            // Guardar la imagen en el nuevo archivo
            Path path = Paths.get(filePath);
            Files.write(path, file.getBytes());

            return randomFileName + fileExtension; // Devuelve el nombre del archivo guardado
        } else {
            throw new IOException("No se pudo encontrar la empresa o el camión.");
        }
    }
    public FallasImagen_Model createErrorImage(FallasImagen_Model fallasImagenModel){
        return fallasImagenRepository.save(fallasImagenModel);
    }

    public FallasImagen_Model editErrorImage(Long id, FallasImagen_Model fallasImagenModel){
        Optional<FallasImagen_Model> existing = fallasImagenRepository.findById(id);
        if(existing.isPresent()){
            FallasImagen_Model errorImage = existing.get();
            errorImage.setObservacion(fallasImagenModel.getObservacion());
            // errorImage.setRgsModel(fallasImagenModel.getRgsModel());
            return fallasImagenRepository.save(errorImage);
        }
        return null;
    }
}
