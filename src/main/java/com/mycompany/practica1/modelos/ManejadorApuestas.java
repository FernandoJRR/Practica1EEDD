package com.mycompany.practica1.modelos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import com.mycompany.practica1.estructuras.ListaApuestas;

public class ManejadorApuestas {
    private float sumaTiempoVerificacionApuestas = 0;
    private int sumaPasosVerificacionApuestas = 0;
    private int cantidadApuestas = 0;
    
    private int mayorCantidadPasos = -1;
    private int menorCantidadPasos = -1;

    public String[] ingresoApuestas(Path directorioArchivo) throws IOException { //Dos pasos O(1)
        String contenidoArchivo = Files.readString(directorioArchivo);
        String[] apuestas = contenidoArchivo.split("\r|\r\n|\n|(\s)*,(\s)*");
        return apuestas;
    }
    
    public ListaApuestas[] verificacionApuestas(String[] datosApuestas) throws IOException{ //Un ciclo, O(n)
        FileWriter myWriter = new FileWriter(System.getProperty("user.home")+"/apuestas_rechazadas.txt"); 

        ListaApuestas listaApuestasAprobadas = new ListaApuestas(); 
        ListaApuestas listaApuestasRechazadas = new ListaApuestas(); 
        String erroresLista = "";
        String apostador = null; 
        float monto = 0; 
        int[] posicionesCaballos = new int[10]; 
        int i=0; //Representa el tipo de dato de la apuesta: 0=nombre, 1=monto, 2-11=posiciones_carrera
        
        for (String datoApuesta : datosApuestas) {
            int pasos = 0;
            Instant starts = Instant.now(); pasos++;
            if (i==0) {
                apostador = datoApuesta; pasos++;
            }
            if (i==1) {
                monto = Float.parseFloat(datoApuesta);pasos++;
            }
            if (2<=i && i<=11) {
                int posicionCaballo = i-1; //Representa la posicion que el apostador cree que terminara un caballo
                int numeroDeCaballo = Integer.parseInt(datoApuesta); //Representa el numero de caballo por el que se apuesta
                pasos+=2;
                if(posicionesCaballos[numeroDeCaballo-1] == 0){
                    posicionesCaballos[numeroDeCaballo-1] = posicionCaballo;pasos++;
                } else {
                    erroresLista += "Se ingreso mas de una vez el caballo "+String.valueOf(numeroDeCaballo)+"\n";pasos++;
                }
            }
            if (i==11) {
                if (erroresLista.equals("")) {
                    listaApuestasAprobadas.agregar(new Apuesta(apostador, monto, posicionesCaballos, erroresLista));pasos++;
                } else {
                    myWriter.write(new Apuesta(apostador, monto, posicionesCaballos, erroresLista).toString());
                    myWriter.write("-----");
                    pasos+=2;                    
                }
                i=0;
                erroresLista = "";
                posicionesCaballos = new int[10];
                pasos+=3;
            } else {
                i++;pasos++;
            }
            Instant ends = Instant.now();
            sumaTiempoVerificacionApuestas += Duration.between(starts, ends).toNanos();
            sumaPasosVerificacionApuestas += pasos;
            cantidadApuestas++;            
            if (pasos>mayorCantidadPasos) {mayorCantidadPasos = pasos;}            
            if (pasos<menorCantidadPasos || menorCantidadPasos==-1) {menorCantidadPasos = pasos;}            
        }
        myWriter.close();
        
        double promedioTiempo = sumaTiempoVerificacionApuestas/cantidadApuestas;
        float promedioPasos = sumaPasosVerificacionApuestas/cantidadApuestas;
        
        ManejadorReportes.crearReporteVerificacionApuesta(
                                                        promedioTiempo, 
                                                        promedioPasos, 
                                                        mayorCantidadPasos, menorCantidadPasos
                                                        );

        return new ListaApuestas[]{listaApuestasAprobadas,listaApuestasRechazadas};
    }
    
    public void crearArchivoRechazados(){
        try {
            File myObj = new File("apuestas_rechazadas.txt");
            if (myObj.createNewFile()) {
            System.out.println("Archivo Creado: " + myObj.getName());
            } else {
            System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }
}
