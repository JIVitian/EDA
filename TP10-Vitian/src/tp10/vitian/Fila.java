/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp10.vitian;

import Interfaces.IFila;

/**
 *
 * @author Iván
 * @param <T>
 */
public class Fila<T> implements IFila<T> {
        
    private Nodo<T> primero;//Primer elemento en la fila
    private Nodo<T> ultimo;//Ultimo elemento ingresado en la fila
    private int tamaño;//Tamaño de la fila

    /**
     * Clase interna para la implementación de Fila con lista simplemente enlazada.
     * Al asignarle un item generico al contenido de los nodos, podemos ingresar cualquier tipo de datos en nuestra fila.
     */
    private class Nodo<T> {

        private T Object;
        private Nodo siguiente;

        public Nodo(T Object) {
            this.Object = Object;
            siguiente = null;
        }

        public T getObject() {
            return Object;
        }

        public void setObject(T Object) {
            this.Object = Object;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    /**
     * FILAVACIA es el constructor de la Fila.
     */
    public Fila() {
        this.tamaño = 0;
        this.primero = null;
        this.ultimo = null;
    }
      
    /**
     * getTamaño nos devuelve el tamaño de la fila.
     * NOTA: Este método no se encuentra en el ADT de Fila pero la uso para devolver la cantidad
     *       de peticiones no atendidas de la correspondiente fila.
     * @return Tamaño de la fila
     */
    public int getTamaño() {
        return tamaño;
    }
    
    /**
     * ESFILAVACIA nos devuelve true si la Fila esta vacia y false en caso contrario
     * @return true o false
     */
    @Override
    public boolean esFilaVacia(){
        return (tamaño == 0);
    }
    
    /**
     * ENFILA Agrega un item al final de la Fila, siendo éste el nodo primero.
     * NOTA: El ADT recibe una Fila y un item, pero en esta implementación no necesariamente le hace falta
     *       recibirlo ya que, podriamos decir que implicitamente lo hace.
     * @param Object caracter correspondiente al nodo
     */
    @Override
    public void enfila(T Object){
        Nodo n = new Nodo(Object);
        if(esFilaVacia()){
            n.setSiguiente(null);
            primero = n;
        }else{
            //Si se va a ingresar el segundo elemento, entonces enlazo a primero con la segunda, siendo esta la ultima
            if(tamaño == 1){
                primero.setSiguiente(n);
                ultimo = n;
            }else{
                ultimo.setSiguiente(n);
                ultimo = n;
            }
        }
        tamaño++;
    }
    
    /**
     * DEFILA Elimina el primer item de la Fila
     * Si la Fila esta vacia entonces no se modifica (Devuelve Fila Vacia)
     */
    @Override
    public void defila(){
        if(!esFilaVacia()){
            primero = primero.getSiguiente();
            tamaño--;
        }
    }
    
    
    /**
     * FRENTE nos devuelve el primer item de la Fila
     * @return
     * @throws NullPointerException 
     */
    @Override
    public T frente() throws NullPointerException {
        if(!esFilaVacia()){
            return primero.getObject();
        }else{
            //Si la Fila es vacia, entonces lanzo una excepción.
            throw new NullPointerException();
        }
    }
    
    /**
     * Muestra todos los elementos de la Fila en forma de lista simplemente enlazada.
     * NOTA: No pertenece al ADT de Fila pero lo necesito para saber si los otros métodos funcionan correctamente.
     * Se usó para probar si la fila funcionaba correctamente
     */
    public void mostrar() {
        Nodo aux;
        aux = primero;
        //La fila se muestra de primero a ultimo
        while (aux != null) {
            System.out.print(aux.getObject() + "->");
            aux = aux.getSiguiente();
        }
        System.out.println("NULL");
    }
    
}
