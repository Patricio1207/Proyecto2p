/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Personal
 */
public class manejoArchivos {
    public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(linea+"\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public static ArrayList<String> LeerArchivo(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
//                System.out.println(linea);
                lineas.add(linea);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;

    }
    
    public static ArrayList<String[]> LeerValidando(String nombreArchivo,boolean saltarPrimeraLinea){
        ArrayList<String> lineas = manejoArchivos.LeerArchivo(nombreArchivo);
        ArrayList<String[]> datos=new ArrayList<>();
        int i;
        if(saltarPrimeraLinea){ 
            for(i=1;i<lineas.size();i++){
                datos.add(lineas.get(i).split(","));
            }
        }else{
            for(i=0;i<lineas.size();i++){
            datos.add(lineas.get(i).split(","));
            }
        }
        
        return datos;
    } 
    
    public static void EliminarLinea(String ruta, int linea){

        // Ruta del archivo
        String rutaArchivo = ruta;
        // Número de línea a borrar
        int numeroLineaABorrar = linea;

        try {
            // Crear un archivo temporal
            File archivoTemporal = new File("archivoTemporal.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal));

            // Leer el archivo original y omitir la línea a borrar
            BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
            String lineaActual;
            int numeroLinea = 1;

            while ((lineaActual = reader.readLine()) != null) {
                // Si no es la línea que se desea borrar
                if (numeroLinea != numeroLineaABorrar) {
             
                    // Escribir la línea sin espacios en el archivo temporal
                    writer.write(lineaActual);
                    writer.newLine();
                }

                numeroLinea++;
            }

            // Cerrar los recursos
            reader.close();
            writer.close();

            // Eliminar el archivo original
            File archivoOriginal = new File(rutaArchivo);
            archivoOriginal.delete();

            // Renombrar el archivo temporal con el nombre del archivo original
            archivoTemporal.renameTo(archivoOriginal);
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
