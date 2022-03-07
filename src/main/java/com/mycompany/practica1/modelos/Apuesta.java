package com.mycompany.practica1.modelos;

public class Apuesta {
    private String apostador;
    private Float montoApostado;
    private int[] ordenCaballos = new int[10];
    private String erroresApuesta;
    private int punteoApuesta = 0;
    
    public Apuesta(String apostador, Float montoApostado, int[] ordenCaballos, String erroresApuesta){
        this.apostador = apostador;
        this.montoApostado = montoApostado;
        this.ordenCaballos = ordenCaballos;
        this.erroresApuesta = erroresApuesta;       
    }
    
    public String toString(){
        String ordenString = "";
        for (int caballo : ordenCaballos) {
            ordenString += String.valueOf(caballo)+",";
        }
        return "Apostador "+apostador+"\nMonto "+String.valueOf(montoApostado)+"\nOrden Apuesta "+ordenString+"\nPunteo "+punteoApuesta+"\n"+erroresApuesta;
    }
    
    public String getApostador() {
        return apostador;
    }

    public int getPunteoApuesta() {
        return punteoApuesta;
    }
    public void setPunteoApuesta(int punteoApuesta) {
        this.punteoApuesta = punteoApuesta;
    }
    
    public int[] getOrdenCaballos() {
        return ordenCaballos;
    }
}
