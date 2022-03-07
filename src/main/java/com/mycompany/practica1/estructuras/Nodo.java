package com.mycompany.practica1.estructuras;

import com.mycompany.practica1.modelos.Apuesta;

public class Nodo {
    Apuesta informacion;
    private Nodo anterior;
    private Nodo siguiente;
    
    public Nodo(Apuesta informacion){
        this.informacion = informacion;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
    
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void agregarAlInicio(Nodo nodoAgregar){
        
    }

    public void imprimirSiguientes(){
        System.out.println(informacion.toString());
        if (siguiente != null) {
            siguiente.imprimirSiguientes();
        }        
    }

    public void imprimirSiguientes(javax.swing.JTextArea areaImpresion){
        System.out.println(informacion.getApostador());
        areaImpresion.setText(areaImpresion.getText()+informacion.toString()+"\n");
        if (siguiente != null) {
            siguiente.imprimirSiguientes(areaImpresion);
        }        
    }
    
    public void imprimirAnteriores(){
        System.out.println(informacion);
        if (anterior != null) {
            anterior.imprimirAnteriores();
        }        
    }

    public void imprimirAnteriores(javax.swing.JTextArea areaImpresion){
        System.out.println(informacion.getPunteoApuesta());
        areaImpresion.setText(areaImpresion.getText()+informacion.toString()+"\n");
        if (anterior != null) {
            anterior.imprimirAnteriores(areaImpresion);
        }        
    }
    
    public int cantidadSiguientes(){
        if (getSiguiente()==null) {
            return 1;
        } else {
            return getSiguiente().cantidadSiguientes()+1;
        }
    }
}
