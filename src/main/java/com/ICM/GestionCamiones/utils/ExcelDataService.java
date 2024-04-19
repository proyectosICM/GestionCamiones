package com.ICM.GestionCamiones.utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;


@Service
public class ExcelDataService {

    public Workbook generarPlantillaExcel() {
        return new XSSFWorkbook(); // Crear un nuevo libro de trabajo Excel en blanco (plantilla)
    }
}

