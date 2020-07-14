/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaCircular;


/**
 * Implementación del ADT Lista Circular a java usando lista simplemente enlazada.ADT LISTAENLAZADA:
 LCVACIA:  LISTACIRCULAR
 LCINSERTAR: LISTACIRCULAR X ITEM  LISTACIRCULAR
 LCVALOR: LISTACIRCULAR  ITEM U {indefinido}
 ESLCVACIA: LISTACIRCULAR  BOOLEAN
 LCBORRAR: LISTACIRCULAR  LISTACIRCULAR
 LCROTAR: LISTACIRCULAR  LISTACIRCULAR
 * 
 * @author Iván
 * @param <T>
 */
public class ListaCircular<T> {
    
    private Nodo<T> LC;
    private int tamaño;

    /**
     * Implementación del constructor LCVACIA
     */
    public ListaCircular() {
        LC = null;
        tamaño = 0;
    }
    
    /**
     * Nos devuelve la cantidad de elementos que contiene la lista circular.
     * @return cant. elementos
     */
    public int getTamaño(){
        return tamaño;
    }
    
    /**
     * LCINSERTAR inserta un elemento en la lista circular, justo adelante del primer elemento. 
     * @param Obj
     */
    public void LCInsertar(T Obj){
        tamaño++;  
        Nodo<T> n = new Nodo<>(Obj);
        if(esLCVacia()){
            LC = n;
            n.setSiguiente(LC);
        }else{
            n.setSiguiente(LC.getSiguiente());
            LC.setSiguiente(n);
        }     
    }
    
    /**
     * LCVALOR devuelve el valor del elemento que esta ubicado en frente del primer elemento de la lista.
     * En éste caso en particular, la lista solo guarda posiciones.
     * @return valor ligado al ultimo elemento.
     */
    public T LCValor(){
        return LC.getSiguiente().getObj();
    }
    
    /**
     * ESLCVACIA verifica si la lista circular tiene o no elementos en ella.
     * @return true si la lista está vacia, false en caso contrario.
     */
    boolean esLCVacia(){
        return LC == null;
    }
    
    /**
     * LCBORRAR elemina el elemento de la lista que esta justo enfrente del primer elemento.
     */
    void LCBorrar(){
        if(!esLCVacia()){
            LC.setSiguiente(LC.getSiguiente().getSiguiente());
            tamaño--;
        }
    }
    
    /**
     * LCROTAR cambia el puntero que apunta al primer elemnto de la lista por el siguiente.
     */
    void LCRotar(){
        if(!esLCVacia()){
            LC = LC.getSiguiente();
        }
    }
     /**
     * Clase interna para la implementación de Fila con lista simplemente enlazada.
     */
    
    /**
     * Muestra todos los elementos de la Lista Citcular en forma de lista simplemente enlazada.
     * NOTA: No pertenece al ADT de Lista Circular pero lo necesito para saber si los otros métodos funcionan correctamente.
     */
    public void mostrar() {
        Nodo aux;
        aux = LC.getSiguiente();
        //La Lista Circular se muestra de primero a ultimo
        while (aux != null) {
            System.out.print(aux.getObj() + "->");
            aux = aux.getSiguiente();
            if(aux == LC){
                break;
            }
        }
        if(esLCVacia())
            System.out.println("NULL");
    }
    
    private class Nodo<T> {

        private T Obj;
        private Nodo<T> siguiente;

        public Nodo(T Obj) {
            this.Obj = Obj;
            siguiente = null;
        }

        public T getObj() {
            return Obj;
        }

        public void setObj(T Obj) {
            this.Obj = Obj;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }
}
