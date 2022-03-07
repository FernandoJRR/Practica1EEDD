package com.mycompany.practica1.modelos;

public class Reporte {
    private double tiempoPromedio;
    private float pasosPromedio;
    private int mayorCantidadPasos;    
    private int menorCantidadPasos;    
    
    public Reporte(double tiempoPromedio, float pasosPromedio, int mayorCantidadPasos, int menorCantidadPasos){
        this.tiempoPromedio = tiempoPromedio;
        this.pasosPromedio = pasosPromedio;
        this.mayorCantidadPasos = mayorCantidadPasos;
        this.menorCantidadPasos = menorCantidadPasos;
    }

    public double getTiempoPromedio() {
        return tiempoPromedio;
    }
    public float getPasosPromedio() {
        return pasosPromedio;
    }
    public int getMayorCantidadPasos() {
        return mayorCantidadPasos;
    }
    public int getMenorCantidadPasos() {
        return menorCantidadPasos;
    }
}
