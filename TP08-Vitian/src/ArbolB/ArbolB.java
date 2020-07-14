/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolB;

/**
 *
 * @author Iván
 * 
 * Implementación del ADT Arbol
 * OPERACIONES:
 * ABVACIO :  AB
 * ARMARAB : AB X ITEM X AB  AB
 * ESABVACIO : AB  BOOLEAN
 * IZQUIERDO : AB  AB
 * RAIZ : AB  ITEM U {indefinido}
 * DERECHO : AB  AB
 * PERTENECE : AB X ITEM  BOOLEAN
 * @param <T>
 */
public class ArbolB<T> {
    
    private ArbolB<T> izquierdo;
    private ArbolB<T> derecho;
    private T raiz;
    
    /**
     * ABVACIO :  AB
     * Crea un nuevo Arbol Binario Vacio.
     * @return Arbol Vacio
     */
    static public ArbolB arbolVacio(){
        return new ArbolB<>();
    }
    
    /**
     * ARMARAB : AB X ITEM X AB  AB
     * Añade subArboles a nuestro Arbol ya creado.
     * @param <T>
     * @param iz
     * @param v
     * @param der
     * @return Arbol modificado
     */
    static public <T> ArbolB armarAB(ArbolB iz, T v, ArbolB der){
        if(v == null) return null;
        
        ArbolB<T> nuevo = arbolVacio();
        
        if(iz == null) {
            nuevo.izquierdo = arbolVacio();
        } else {
            nuevo.izquierdo = iz;
        }
        
        if(der == null) {
            nuevo.derecho = arbolVacio();
        } else {
            nuevo.derecho = der;
        }
        
        nuevo.raiz = v;
        
        return nuevo;
    }
    
    /**
     * ESABVACIO : AB  BOOLEAN
     * Nos dice si el Arbol está vacio.
     * @return 
     */
    public boolean esABVacio() {
        return raiz == null;
    }
    
    /**
     * IZQUIERDO : AB  AB
     * Devuelve el SubArbol izquierdo de nuestro arbol
     * @return izquierdo
     */
    public ArbolB<T> izquierdo() {
        return this.izquierdo;
    }
    
    /**
     * RAIZ : AB  ITEM U {indefinido}
     * Devuelve la raíz de nuestro Arbol.
     * @return 
     */
    public T raiz() {
        return raiz;
    }
    
    /**
     * DERECHO : AB  AB
     * Devuelve el SubArbol derecho de nuestro Arbol.
     * @return derecho
     */
    public ArbolB<T> derecho() {
        return this.derecho;
    }
    
    /**
     * PERTENECE : AB X ITEM  BOOLEAN
     * Devuelve true si el element pertenece al Arbol Binario y false en caso contrario.
     * @param c
     * @return true o false
     */
    public boolean pertenece(T c) {
        if(esABVacio()) return false;
        if(raiz == c) return true;
        return izquierdo().pertenece(c) || derecho().pertenece(c);
    }
    
    /**
     * Método auxiliar que muestra los nodos del arbol binario en preorden.
     */
    public void preorden() {
        if(!esABVacio()){
            System.out.print(raiz + " ");
            izquierdo().preorden();
            derecho().preorden();
        }
    }
    
    /**
     * Método auxiliar que muestra los nodos del arbol binario en orden simetrico.
     */
    public void inorden() { 
        if(!esABVacio()){
            izquierdo().inorden();
            System.out.print(raiz + " ");
            derecho().inorden();
        }
    }
    
    /**
     * Método auxiliar que muestra los nodos del arbol binario en postorden.
     */
    public void postorden() {
        if(!esABVacio()){
            izquierdo().postorden();
            derecho().postorden();
            System.out.print(raiz + " ");
        }
    }
}
