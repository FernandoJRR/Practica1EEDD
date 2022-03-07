/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1;

import java.io.IOException;
import java.nio.file.Path;

import com.mycompany.practica1.estructuras.ListaApuestas;
import com.mycompany.practica1.modelos.ManejadorApuestas;
import com.mycompany.practica1.modelos.ModelCarreras;

import interfaz.Interfaz;

/**
 *
 * @author fernanrod
 */
public class Main {
    public static void main(String[] args) {
        /*
        try {
            Path directorioArchivo = Path.of("pruebapractica1EEDD.txt");
            ModelCarreras.cargarApuestas(directorioArchivo);
            ModelCarreras.realizarCarrera();
            ModelCarreras.verificarResultados();
            System.out.println("Resultados carrera:");
            for (int caballo : ModelCarreras.getPosicionesFinales()) {
                System.out.println(caballo);
            }
            System.out.println("Punteo apostadores");
            ModelCarreras.getApuestasAprobadas().imprimirPrincipioAFinal();
            System.out.println("Punteo apostadores ordenado punteo");
            ModelCarreras.getApuestasAprobadas().ordenarPorPunteo();
            ModelCarreras.getApuestasAprobadas().imprimirPrincipioAFinal();
            System.out.println("Punteo apostadores ordenado nombre");
            ModelCarreras.getApuestasAprobadas().ordenarAlfabeticamente();;
            ModelCarreras.getApuestasAprobadas().imprimirPrincipioAFinal();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            StackTraceElement[] elements = e.getStackTrace();
            System.out.println(elements[0]);
        }        
        */
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);
    }

}
