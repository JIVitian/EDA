/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 * Implementación del ADT FILA dada en el trabajo en el TP6 de EDA.
 * FILAVACIA: -> FILA
 * ESFILAVACIA: FILA -> Boolean
 * ENFILA: FILA x item -> FILA
 * DEFILA: FILA -> FILA
 * FRENTE: FILA -> item U {indefinido}
 * 
 * @author Iván
 * @param <T>
 */
public interface IFila<T> {
    boolean esFilaVacia();
    void enfila(T object);
    void defila();
    T frente();
}
