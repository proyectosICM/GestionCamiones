package com.ICM.GestionCamiones.utils;

import com.ICM.GestionCamiones.models.CheckListCamionModel;
import com.ICM.GestionCamiones.service.CheckListCamionService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class ExcelDataController {
    @Autowired
    CheckListCamionService checkListCamionService;

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
        Resource resource = new ClassPathResource("plantilla2.xlsx");

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

    @GetMapping("/cargar-excel2")
    public ResponseEntity<Resource> cargarPlantillaExcel2(HttpServletResponse response) throws IOException {



        // Cargar el archivo plantilla1.xlsx como un recurso desde la carpeta resources
        Resource resource = new ClassPathResource("plantilla2.xlsx");

        // Leer el archivo Excel y modificar el valor de la celda A10 en la primera hoja
        Workbook workbook = new XSSFWorkbook(resource.getInputStream());
        Sheet sheet1 = workbook.getSheetAt(0);
        Row row1 = sheet1.getRow(9); // Fila 10, ya que las filas se numeran desde 0
        Cell cell1 = row1.getCell(0); // Columna A (0-indexed)
        // Establecer el valor de la celda A10 en la primera hoja como "ANNA"
        cell1.setCellValue("ANNA");

        // Leer el archivo Excel y modificar el valor de la celda A10 en la segunda hoja
        Sheet sheet2 = workbook.getSheetAt(1); // Segunda hoja
        Row row2 = sheet2.getRow(9); // Fila 10, ya que las filas se numeran desde 0
        if(row2 == null) {
            // Si la segunda fila es nula, crea una nueva fila
            row2 = sheet2.createRow(9);
        }
        Cell cell2 = row2.getCell(0); // Columna A (0-indexed)
        if(cell2 == null) {
            // Si la celda es nula, crea una nueva celda
            cell2 = row2.createCell(0);
        }
        // Establecer el valor de la celda A10 en la segunda hoja como "Juan"
        cell2.setCellValue("Juan");

        // Escribir los cambios en el flujo de salida
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        byte[] excelBytes = outputStream.toByteArray();

        // Cerrar el libro de trabajo Excel
        workbook.close();

        // Configurar la respuesta HTTP para la descarga del archivo Excel modificado
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "plantilla2_modificada.xlsx"); // Nombre del archivo a descargar

        // Devolver la respuesta con el archivo Excel modificado
        return ResponseEntity.ok()
                .headers(headers)
                .body(new ByteArrayResource(excelBytes));
    }

    @GetMapping("/cargar-excel-datos")
    public ResponseEntity<Resource> cargarPlantillaExcelDatos(HttpServletResponse response, @RequestParam Long id) throws IOException {
        // Obtener los datos de la lista de verificación del camión para el ID de la empresa
        List<CheckListCamionModel> datosclcamion = checkListCamionService.findByCamionesModelEmpresasModelId(id);

        // Cargar el archivo plantilla1.xlsx como un recurso desde la carpeta resources
        Resource resource = new ClassPathResource("plantilla1.xlsx");

        // Leer el archivo Excel
        Workbook workbook = new XSSFWorkbook(resource.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        // Escribir las placas de los carros en la columna A a partir de la fila 7
        // el tipo de camión en la columna B, RevisarAjuste en la columna D y CortesYAverias en la columna E a partir de la fila 7
        int rowNum = 6; // Fila 7, ya que las filas se numeran desde 0
        for (CheckListCamionModel checkListCamion : datosclcamion) {
            // Obtener la placa del carro y escribirla en la columna A
            String placa = checkListCamion.getCamionesModel().getPlaca();
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }
            Cell cellPlaca = row.getCell(0);
            if (cellPlaca == null) {
                cellPlaca = row.createCell(0);
            }
            cellPlaca.setCellValue(placa);

            // Obtener el tipo de camión y escribirlo en la columna B
            String tipoCamion = checkListCamion.getCamionesModel().getTiposCModel().getNombre();
            Cell cellTipoCamion = row.getCell(1);
            if (cellTipoCamion == null) {
                cellTipoCamion = row.createCell(1);
            }
            cellTipoCamion.setCellValue(tipoCamion);

            // Obtener la propiedad RevisarAjuste y escribir "En Buen Estado" o "En Mal Estado" en la columna D
            Boolean revisarAjuste = checkListCamion.getRevisarAjuste();
            Cell cellRevisarAjuste = row.getCell(3); // Columna D
            if (cellRevisarAjuste == null) {
                cellRevisarAjuste = row.createCell(3);
            }
            if (revisarAjuste != null) {
                if (revisarAjuste) {
                    cellRevisarAjuste.setCellValue("Buen Estado");
                } else {
                    cellRevisarAjuste.setCellValue("Mal Estado");
                }
            }

            // Obtener la propiedad CortesYAverias y escribir "En Buen Estado" o "En Mal Estado" en la columna E
            Boolean cortesYAverias = checkListCamion.getCortesYAverias();
            Cell cellCortesYAverias = row.getCell(4); // Columna E
            if (cellCortesYAverias == null) {
                cellCortesYAverias = row.createCell(4);
            }
            if (cortesYAverias != null) {
                if (cortesYAverias) {
                    cellCortesYAverias.setCellValue("Buen Estado");
                } else {
                    cellCortesYAverias.setCellValue("Mal Estado");
                }
            }

            rowNum++;
        }

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

    @GetMapping("/cargar-excel-datos2")
    public ResponseEntity<Resource> cargarPlantillaExcelDatos2(HttpServletResponse response, @RequestParam Long id) throws IOException {
        // Obtener los datos de la lista de verificación del camión para el ID de la empresa
        List<CheckListCamionModel> datosclcamion = checkListCamionService.findByCamionesModelEmpresasModelId(id);

        // Cargar el archivo plantilla1.xlsx como un recurso desde la carpeta resources
        Resource resource = new ClassPathResource("plantilla1.xlsx");

        // Leer el archivo Excel
        Workbook workbook = new XSSFWorkbook(resource.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);



        // Escribir los datos en el archivo Excel
        int rowNum = 6; // Fila 7, ya que las filas se numeran desde 0
        for (CheckListCamionModel checkListCamion : datosclcamion) {
            String placa = checkListCamion.getCamionesModel().getPlaca();
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }
            Cell cellPlaca = row.getCell(0);
            if (cellPlaca == null) {
                cellPlaca = row.createCell(0);
            }
            cellPlaca.setCellValue(placa);

            // Obtener el tipo de camión y escribirlo en la columna B
            String tipoCamion = checkListCamion.getCamionesModel().getTiposCModel().getNombre();
            Cell cellTipoCamion = row.getCell(1);
            if (cellTipoCamion == null) {
                cellTipoCamion = row.createCell(1);
            }
            cellTipoCamion.setCellValue(tipoCamion);
            // Escribir las propiedades en las columnas respectivas
            //Llantas
            rowNum = escribirPropiedadEnColumna(checkListCamion.getRevisarAjuste(), sheet, rowNum, 3);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getCortesYAverias(), sheet, rowNum, 4);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getRevisarPresionRecomendada(), sheet, rowNum, 5);
            //Motor
            rowNum = escribirPropiedadEnColumna(checkListCamion.getNivelesDeMotor(), sheet, rowNum, 6);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getSistemaDeLubricacionDeFugas(), sheet, rowNum, 7);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getSistemaDeCombustible(), sheet, rowNum, 8);
            // Sistema Electrico
            rowNum = escribirPropiedadEnColumna(checkListCamion.getLuces(), sheet, rowNum, 9);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getSistemaDeCarga(), sheet, rowNum, 10);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getMandosTablero(), sheet, rowNum, 11);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getSistemaDeArranque(), sheet, rowNum, 12);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getRuidosAnormalesSE(), sheet, rowNum, 13);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getOtrosEquiposElectricos(), sheet, rowNum, 14);
            //Transmision
            rowNum = escribirPropiedadEnColumna(checkListCamion.getEmbrague(), sheet, rowNum, 15);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getCajaDeCambio(), sheet, rowNum, 16);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getDiferencial(), sheet, rowNum, 17);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getCardanes(), sheet, rowNum, 18);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getRuidosAnormalesT(), sheet, rowNum, 19);
            // Direccion
            rowNum = escribirPropiedadEnColumna(checkListCamion.getSeryo(), sheet, rowNum, 20);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getAlineamiento(), sheet, rowNum, 21);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getPinesBocinasTerminales(), sheet, rowNum, 22);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getCajaDeDirecion(), sheet, rowNum, 23);
            // Frenos
            rowNum = escribirPropiedadEnColumna(checkListCamion.getLimpiezaYRegulacion(), sheet, rowNum, 24);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getPresionDeAire(), sheet, rowNum, 25);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getFrenoDeEstacionamiento(), sheet, rowNum, 26);
            // Suspension
            rowNum = escribirPropiedadEnColumna(checkListCamion.getMuellesBolsasdeAire(), sheet, rowNum, 27);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getAmortiguadores(), sheet, rowNum, 28);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getEjesBarraEstabilizadora(), sheet, rowNum, 29);
            // Cabina
            rowNum = escribirPropiedadEnColumna(checkListCamion.getCarroceria(), sheet, rowNum, 30);
            rowNum = escribirPropiedadEnColumna(checkListCamion.getChasis(), sheet, rowNum, 31);
            // Aquí puedes agregar más llamadas al método para otras propiedades

            rowNum++; // Avanzar a la siguiente fila
        }

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

    // Método para escribir una propiedad en una columna del archivo Excel
    private int escribirPropiedadEnColumna(Boolean propiedad, Sheet sheet, int rowNum, int columnNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.getCell(columnNum);
        if (cell == null) {
            cell = row.createCell(columnNum);
        }
        if (propiedad != null) {
            if (propiedad) {
                cell.setCellValue("Buen Estado");
            } else {
                cell.setCellValue("Mal Estado");
            }
        }
        return rowNum;
    }
}
