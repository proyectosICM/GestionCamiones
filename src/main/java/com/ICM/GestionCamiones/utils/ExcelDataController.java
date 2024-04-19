package com.ICM.GestionCamiones.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class ExcelDataController {

    @GetMapping("/descargar-excel")
    public ResponseEntity<Resource> descargarPlantillaExcel(HttpServletResponse response) throws IOException {
        // Cargar el archivo clc.xlsx como un recurso desde la carpeta resources
        Resource resource = new ClassPathResource("plantilla1.xlsx");

        // Configurar la respuesta HTTP para la descarga del archivo Excel
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "clc.xlsx"); // Nombre del archivo a descargar

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

    @GetMapping("/cargar-excel")
    public ResponseEntity<Resource> cargarPlantillaExcel(HttpServletResponse response) throws IOException {
        // Cargar el archivo plantilla1.xlsx como un recurso desde la carpeta resources
        Resource resource = new ClassPathResource("plantilla1.xlsx");

        // Leer el archivo Excel y modificar el valor de la celda A10
        Workbook workbook = new XSSFWorkbook(resource.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(9); // Fila 10, ya que las filas se numeran desde 0
        Cell cell = row.getCell(0); // Columna A (0-indexed)

        // Establecer el valor de la celda A10 como "ANNA"
        cell.setCellValue("ANNA");

        // Escribir los cambios en el flujo de salida
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        byte[] excelBytes = outputStream.toByteArray();

        // Cerrar el libro de trabajo Excel
        workbook.close();

        // Configurar la respuesta HTTP para la descarga del archivo Excel modificado
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "plantilla1_modificada.xlsx"); // Nombre del archivo a descargar

        // Devolver la respuesta con el archivo Excel modificado
        return ResponseEntity.ok()
                .headers(headers)
                .body(new ByteArrayResource(excelBytes));
    }
}
