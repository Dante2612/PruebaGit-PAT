package com.mycompany.archivoexcel.Lógica;

import java.util.ArrayList;
//Librerías java.io
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
//Librerías org.apache.poi
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class Excel {

    public static void CrearApartirDeArrayList() {

        int índiceFila = 0;

        ArrayList<Persona> personas = new ArrayList();

        personas.add(new Persona(1, "Carlos", "Torres", 35262545, "Calle Los Nogales 430 Surco", "ctorres@gmail.com"));
        personas.add(new Persona(2, "Ana", "Diaz", 45789562, "Calle Independencia 123 Lince", "adiaz@gmail.com"));
        personas.add(new Persona(3, "Juan", "Guitierrez", 85963215, "Calle Las Dalias 387 Callado", "igutierrez@gmail.com"));

        Workbook libro = new HSSFWorkbook();
        final String nombreArchivo = "DatosDePersonas.xls";
        Sheet hoja = libro.createSheet("Hoja 1");

        //Creación de encabezados en la Fila 1 en Excel
        String[] encabezados = {"NÚMERO", "NOMBRE", "APELLIDO", "DNI", "DIRECCIÓN", "CORREO"};

        Row fila = hoja.createRow(índiceFila);
        for (int i = 0; i < encabezados.length; i++) {
            String encabezado = encabezados[i];
            Cell celda = fila.createCell(i);
            celda.setCellValue(encabezado);
        }

        índiceFila++;
        //Creación de los datos de cada persona en Excel
        for (int i = 0; i < personas.size(); i++) {
            fila = hoja.createRow(índiceFila);
            Persona persona = personas.get(i);
            fila.createCell(0).setCellValue(persona.getNumero());
            fila.createCell(1).setCellValue(persona.getNombre());
            fila.createCell(2).setCellValue(persona.getApellido());
            fila.createCell(3).setCellValue(persona.getDni());
            fila.createCell(4).setCellValue(persona.getDirección());
            fila.createCell(5).setCellValue(persona.getCorreo());

            índiceFila++;
        }

        //Guardado del archivo Excel nuestros documentos;
        File directorioActual = new File(".");
        String ubicación = directorioActual.getAbsolutePath();
        String ubicaciónFinal = ubicación.substring(0, ubicación.length() - 1) + nombreArchivo;
        FileOutputStream outputStream;

        try {

            outputStream = new FileOutputStream(ubicaciónFinal);
            libro.write(outputStream);
            libro.close();
            System.out.println("Archivo guardado correctamente");

        } catch (FileNotFoundException ex) {
            System.out.println("Error de Filenotfoung");
        } catch (IOException ex) {
            System.out.println("Error de IOException");
        }

    }

}
