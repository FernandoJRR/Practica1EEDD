package com.mycompany.practica1.modelos;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;

import com.mycompany.practica1.estructuras.ListaApuestas;

public class ModelCarreras {
    static ManejadorApuestas manejadorApuestas = new ManejadorApuestas();
    static ListaApuestas apuestasAprobadas = new ListaApuestas();
    static int[] posicionesFinales = new int[10];
    
    public static ManejadorApuestas getManejadorApuestas() {
        return manejadorApuestas;
    }
    public static int[] getPosicionesFinales() {
        return posicionesFinales;
    }
    public static ListaApuestas getApuestasAprobadas() {
        return apuestasAprobadas;
    }
 
    public static void cargarApuestas(Path directorioArchivo) throws IOException{
        String[] listaApuestas = manejadorApuestas.ingresoApuestas(directorioArchivo);
        apuestasAprobadas = manejadorApuestas.verificacionApuestas(listaApuestas)[0];
    }
    
    public static void realizarCarrera(){
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int caballo = rand.nextInt(10)+1;
            while (enArreglo(posicionesFinales, caballo)) {
                caballo = rand.nextInt(10)+1;
            }
            posicionesFinales[i] = caballo;
        }
    }
    
    public static boolean enArreglo(int[] arreglo, int valor){
        for (int i : arreglo) {
            if (i==valor) {
                return true;
            }
        }
        return false;
    }
    
    public static void verificarResultados(){
        apuestasAprobadas.verificarResultados(posicionesFinales);
    }
    
}