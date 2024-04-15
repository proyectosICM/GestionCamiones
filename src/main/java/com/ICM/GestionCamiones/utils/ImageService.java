package com.ICM.GestionCamiones.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageService {
    @Value("${file.image}")
    private String fileImagen;

    public void saveImage(MultipartFile file, String nombreCarpeta) throws IOException {
        String filePath = fileImagen + "/" + nombreCarpeta + "/";
        File directory = new File(filePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        Path path = Paths.get(filePath + file.getOriginalFilename());
        Files.write(path, file.getBytes());
    }
}
