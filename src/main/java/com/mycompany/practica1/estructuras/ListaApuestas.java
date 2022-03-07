package com.mycompany.practica1.estructuras;

import java.time.Duration;
import java.time.Instant;

import com.mycompany.practica1.modelos.Apuesta;
import com.mycompany.practica1.modelos.ManejadorReportes;

public class ListaApuestas {
    Nodo head;
    Nodo tail;

    private float sumaTiempoVerificacionResultados = 0;
    private int sumaPasosVerificacionResultados = 0;
    private int cantidadApuestas = 0;
    
    private int mayorCantidadPasosResultados = -1;
    private int menorCantidadPasosResultados = -1;

    private float sumaTiempoOrdenamientoPunteo = 0;
    private int sumaPasosOrdenamientoPunteo = 0;
    
    private int mayorCantidadPasosOrdenamientoPunteo = -1;
    private int menorCantidadPasosOrdenamientoPunteo = -1;


    private float sumaTiempoOrdenamientoAlfabetico = 0;
    private int sumaPasosOrdenamientoAlfabetico = 0;
    
    private int mayorCantidadPasosOrdenamientoAlfabetico = -1;
    private int menorCantidadPasosOrdenamientoAlfabetico = -1;

    public ListaApuestas(Nodo head){
        this.head = head;
        this.tail = head;
    }
    
    public ListaApuestas(){
        this.head = null;
        this.tail = null;
    }
    
    public void agregarAlInicio(Nodo nodoAgregar){ //O(1)
        head.setAnterior(nodoAgregar);
        head.getAnterior().setSiguiente(head);        
        
        head = head.getAnterior();
    }
    
    public void agregarAlFinal(Nodo nodoAgregar){ //O(1)
        if (tail!=null) {
            tail.setSiguiente(nodoAgregar);
            tail.getSiguiente().setAnterior(tail);        
            
            tail = tail.getSiguiente();
        } else {
            head = nodoAgregar;
            tail = nodoAgregar;
        }
    }
   
    public void agregar(Nodo nodoAgregar){
        if (tail!=null) {
            tail.setSiguiente(nodoAgregar);
            tail.getSiguiente().setAnterior(tail);        
            
            tail = tail.getSiguiente();
        } else {
            head = nodoAgregar;
            tail = nodoAgregar;
        }
    }
    
    public void agregar(Apuesta apuestaAgregar){
        Nodo nodoAgregar = new Nodo(apuestaAgregar);
        if (tail!=null) {
            tail.setSiguiente(nodoAgregar);
            tail.getSiguiente().setAnterior(tail);        
            
            tail = tail.getSiguiente();
        } else {
            head = nodoAgregar;
            tail = nodoAgregar;
        }
    }
    
    public void imprimirPrincipioAFinal(){ //O(n)
        head.imprimirSiguientes();
    }

    public void imprimirPrincipioAFinal(javax.swing.JTextArea areaImpresion){ //O(n)
        head.imprimirSiguientes(areaImpresion);
    }
    
    public void imprimirFinalAPrincipio(){ //O(n)
        tail.imprimirAnteriores();
    }
    
    public void imprimirFinalAPrincipio(javax.swing.JTextArea areaImpresion){
        tail.imprimirAnteriores(areaImpresion);
    } 
    
    public int size(){
        return head.cantidadSiguientes();
    }
    
    public int buscar(Apuesta informacionBuscada){ //O(n)
        if (head.informacion.equals(informacionBuscada)) {
            return 0;
        } else {
            return buscarEnLista(head.getSiguiente(), 1, informacionBuscada);
        }
    }
    
    public int buscarEnLista(Nodo nodoActual, int indiceNodo, Apuesta informacionBuscada){ //O(n)
        if (nodoActual.informacion.equals(informacionBuscada)) {
            return indiceNodo;
        } else {
            if (nodoActual.getSiguiente() != null) {
                return buscarEnLista(nodoActual.getSiguiente(), indiceNodo+1, informacionBuscada);
            } else {
                return -1;
            }
        }
    }
    
    public void eliminar(Apuesta informacionEliminar){ //O(n)
        eliminarEnLista(head, informacionEliminar);
    }
    
    public void eliminarEnLista(Nodo nodoActual, Apuesta informacionEliminar){ //O(n)
        if ((nodoActual.informacion.equals(informacionEliminar)) && (nodoActual!=head) && (nodoActual!=tail)) {
            if (nodoActual.getSiguiente() != null) {
                nodoActual.getAnterior().setSiguiente(nodoActual.getSiguiente());
                nodoActual.getSiguiente().setAnterior(nodoActual.getAnterior());
                Nodo siguiente = nodoActual.getSiguiente();
                nodoActual.setAnterior(null);
                nodoActual.setSiguiente(null);
                nodoActual.informacion = null;
                eliminarEnLista(siguiente, informacionEliminar);
            } else {
                nodoActual.getAnterior().setSiguiente(null);
                nodoActual.setAnterior(null);
                nodoActual.setSiguiente(null);
                nodoActual.informacion = null;
            }
        } else if (nodoActual.informacion.equals(informacionEliminar) && (nodoActual==head)) {
            if (nodoActual.getSiguiente() != null) {
                head = nodoActual.getSiguiente();
                head.setAnterior(null);
                nodoActual.setSiguiente(null);
                nodoActual.informacion = null;
                eliminarEnLista(head, informacionEliminar);
            } else {
                nodoActual.setAnterior(null);
                nodoActual.setSiguiente(null);
                nodoActual.informacion = null;
            }
        } else if (nodoActual.informacion.equals(informacionEliminar) && (nodoActual==tail)){
            tail = tail.getAnterior();
            tail.setSiguiente(null);
            nodoActual.setAnterior(null);
            nodoActual.setSiguiente(null);
            nodoActual.informacion = null;
        } else {
            if (nodoActual.getSiguiente() != null) {
                eliminarEnLista(nodoActual.getSiguiente(), informacionEliminar);
            }
        }
    }
    
    public void verificarResultados(int[] resultadosCarrera){
        verificarResultadoNodo(head, resultadosCarrera);
        ManejadorReportes.crearReporteCalculoResultados(
                                                        sumaTiempoVerificacionResultados/cantidadApuestas, 
                                                        sumaPasosVerificacionResultados/cantidadApuestas, 
                                                        mayorCantidadPasosResultados, menorCantidadPasosResultados
                                                    );
    }
    
    private void verificarResultadoNodo(Nodo nodoApuesta, int[] resultadosCarrera){
        int pasos = 0;
        Instant starts = Instant.now();
        Apuesta apuesta = nodoApuesta.informacion;
        int[] ordenCaballos = apuesta.getOrdenCaballos();
        for (int i = 0; i < 10; i++) {
            if (ordenCaballos[i]==resultadosCarrera[i]) {
                apuesta.setPunteoApuesta(apuesta.getPunteoApuesta()+10-i);
            }
            pasos++;
        }
        Instant ends = Instant.now();
        sumaTiempoVerificacionResultados += Duration.between(starts, ends).toNanos();
        sumaPasosVerificacionResultados += pasos;
        cantidadApuestas++;            
        if (pasos>mayorCantidadPasosResultados) {mayorCantidadPasosResultados = pasos;}            
        if (pasos<menorCantidadPasosResultados || menorCantidadPasosResultados==-1) {menorCantidadPasosResultados = pasos;}            

        if (nodoApuesta.getSiguiente()!=null) {
            verificarResultadoNodo(nodoApuesta.getSiguiente(), resultadosCarrera);
        }
    }
    
    public void ordenarPorPunteo(){ //Dos ciclos, O(n^2)
        Instant starts = Instant.now();
        if (size() > 1) {
            for (int i = 0; i < size(); i++ ) {
                Nodo nodoActual = head;
                Nodo next = head.getSiguiente();
                sumaPasosOrdenamientoPunteo+=2;
                for (int j = 0; j < size() - 1; j++) {
                    if (nodoActual.informacion.getPunteoApuesta() > next.informacion.getPunteoApuesta()) {
                        swapNodos(nodoActual, next, false);
                        sumaPasosOrdenamientoPunteo+=4;
                    } 
                    nodoActual = next;
                    next = next.getSiguiente();                   
                    sumaPasosOrdenamientoPunteo+=2;
                } 
            }
        }
        Instant ends = Instant.now();
        sumaTiempoOrdenamientoPunteo = Duration.between(starts, ends).toNanos();
        ManejadorReportes.crearReporteOrdenamientoPunteo(sumaTiempoOrdenamientoPunteo/cantidadApuestas, 
                                                        sumaPasosOrdenamientoPunteo/cantidadApuestas
                                                        );
    }
    
    public void ordenarAlfabeticamente(){
        Instant starts = Instant.now();
        if (size() > 1) {
            for (int i = 0; i < size(); i++ ) {
                Nodo nodoActual = head;
                Nodo next = head.getSiguiente();
                sumaPasosOrdenamientoAlfabetico+=2;
                for (int j = 0; j < size() - 1; j++) {
                    if (nodoActual.informacion.getApostador().compareTo(next.informacion.getApostador()) > 0) {
                        swapNodos(nodoActual, next, true);
                        sumaPasosOrdenamientoAlfabetico+=4;
                    } 
                    nodoActual = next;
                    next = next.getSiguiente();                   
                    sumaPasosOrdenamientoAlfabetico+=2;
                } 
            }
        }
        Instant ends = Instant.now();
        sumaTiempoOrdenamientoAlfabetico = Duration.between(starts, ends).toNanos();
        ManejadorReportes.crearReporteOrdenamientoAlfabetico(
                                                        sumaTiempoOrdenamientoAlfabetico/cantidadApuestas, 
                                                        sumaPasosOrdenamientoAlfabetico/cantidadApuestas
                                                        );
    }
    
    public void swapNodos(Nodo primerNodo, Nodo segundoNodo, boolean alfabetico){
        if (primerNodo.getAnterior()!=null) {
            primerNodo.getAnterior().setSiguiente(segundoNodo);
            if (alfabetico) {sumaPasosOrdenamientoAlfabetico++;} 
            else {sumaPasosOrdenamientoPunteo++;}
        }
        if (segundoNodo.getSiguiente()!=null) {
            segundoNodo.getSiguiente().setAnterior(primerNodo);
            if (alfabetico) {sumaPasosOrdenamientoAlfabetico++;} 
            else {sumaPasosOrdenamientoPunteo++;}
        }
        
        segundoNodo.setAnterior(primerNodo.getAnterior());
        primerNodo.setSiguiente(segundoNodo.getSiguiente());
        segundoNodo.setSiguiente(primerNodo);
        primerNodo.setAnterior(segundoNodo);

        if (primerNodo == head) {
            head = segundoNodo;
            if (alfabetico) {sumaPasosOrdenamientoAlfabetico++;} 
            else {sumaPasosOrdenamientoPunteo++;}
        }
        if (segundoNodo==tail) {
            tail = primerNodo;
            if (alfabetico) {sumaPasosOrdenamientoAlfabetico++;} 
            else {sumaPasosOrdenamientoPunteo++;}
        }
    }
}
