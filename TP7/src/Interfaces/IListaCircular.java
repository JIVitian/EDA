/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 * Implementación del ADT Lista Circular a java usando lista simplemente enlazada.
 * ADT LISTAENLAZADA:
 * LCVACIA:  LISTACIRCULAR
 * LCINSERTAR: LISTACIRCULAR X ITEM  LISTACIRCULAR
 * LCVALOR: LISTACIRCULAR  ITEM U {indefinido}
 * ESLCVACIA: LISTACIRCULAR  BOOLEAN
 * LCBORRAR: LISTACIRCULAR  LISTACIRCULAR
 * LCROTAR: LISTACIRCULAR  LISTACIRCULAR
 * 
 * @author Iván
 * @param <T>
 */
public interface IListaCircular<T> {
    /**
     * LCINSERTAR inserta un elemento en la lista circular, justo adelante del primer elemento.
     * @param Obj 
     */
    void LCInsertar(T Obj);
    
    /**
     * LCVALOR devuelve el valor del elemento que esta ubicado en frente del primer elemento de la lista.
     * @return valor ligado al ultimo elemento.
     */
    T LCValor();
    
    /**
     * ESLCVACIA verifica si la lista circular tiene o no elementos en ella.
     * @return true si la lista está vacia, false en caso contrario.
     */
    boolean esLCVacia();
    
    /**
     * LCBORRAR elemina el elemento de la lista que esta justo enfrente del primer elemento.
     */
    void LCBorrar();
    
    /**
     * LCROTAR cambia el puntero que apunta al primer elemnto de la lista por el siguiente.
     */
    void LCRotar();
    
}
