/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fila;


/**
 *
 * @author danie
 */
public class Peticion {
    private final int tiempo;//Tiempo de procesamiento de la petición
    private final int t_in;//Momento en el que la petición entra en la fila
    
    public Peticion(int t_in, int tiempo){
        this.tiempo = tiempo;
        this.t_in = t_in;
    }

    public int getT_in() {
        return t_in;
    }

    public int getTiempo() {
        return tiempo;
    }

}
