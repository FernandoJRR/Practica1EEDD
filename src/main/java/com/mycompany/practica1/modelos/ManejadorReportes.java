package com.mycompany.practica1.modelos;

public class ManejadorReportes {
    static private Reporte reporteVerificacionApuesta; 
    static private Reporte reporteCalculoResultados; 
    static private Reporte reporteOrdenamientoPunteo; 
    static private Reporte reporteOrdenamientoAlfabetico;
    
    public static void crearReporteVerificacionApuesta(double tiempoPromedio, float pasosPromedio, int mayorCantidadPasos, int menorCantidadPasos){
        reporteVerificacionApuesta = new Reporte(tiempoPromedio, pasosPromedio, mayorCantidadPasos, menorCantidadPasos);
    }
    public static void crearReporteCalculoResultados(double tiempoPromedio, float pasosPromedio, int mayorCantidadPasos, int menorCantidadPasos){
        reporteCalculoResultados = new Reporte(tiempoPromedio, pasosPromedio, mayorCantidadPasos, menorCantidadPasos);
    }
    public static void crearReporteOrdenamientoPunteo(double tiempoPromedio, float pasosPromedio){
        reporteOrdenamientoPunteo = new Reporte(tiempoPromedio, pasosPromedio, 0, 0);
    }
    public static void crearReporteOrdenamientoAlfabetico(double tiempoPromedio, float pasosPromedio){
        reporteOrdenamientoAlfabetico = new Reporte(tiempoPromedio, pasosPromedio, 0, 0);
    }
    
    public static Reporte getReporteVerificacionApuesta() {
        return reporteVerificacionApuesta;
    }
    public static Reporte getReporteCalculoResultados() {
        return reporteCalculoResultados;
    }
    public static Reporte getReporteOrdenamientoPunteo() {
        return reporteOrdenamientoPunteo;
    }
    public static Reporte getReporteOrdenamientoAlfabetico() {
        return reporteOrdenamientoAlfabetico;
    }
}
