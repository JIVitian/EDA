/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;

/**
 *
 * @author Iván
 */
public class Pila {
    
    private Nodo tope;
    private int tamaño;

    private class Nodo {

        private char letra;
        private Nodo siguiente;

        public Nodo(char letra) {
            this.letra = letra;
            siguiente = null;
        }

        public char getLetra() {
            return letra;
        }

        public void setLetra(char letra) {
            this.letra = letra;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    } 
    
    
    /**
     * PILAVACIA es el constructor de la pila
     */
    public Pila() {
        this.tamaño = 0;
    }
    
    /**
     * ESPILAVACIA nos devuelve true si la pila esta vacia y false en caso contrario
     * @return true o false
     */
    public boolean esPilaVacia(){
        return (tamaño == 0);
    }
    
    /**
     * PUSH Agrega un nodo al tope de la pila, siendo éste el nodo primero.
     * NOTA: El ADT recibe una PILA y un item, pero en esta implementación no necesariamente le hace falta recibirlo ya que, podriamos decir que implicitamente lo hace.
     * @param letra caracter correspondiente al nodo
     */
    public void push(char letra){
        Nodo n = new Nodo(letra);
        n.setSiguiente(tope);
        tope = n;
        tamaño++;
    }
    
    /**
     * POP Elimina el Tope de la Pila
     * Si la pila esta vacia entonces no se modifica (Devuelve pila Vacia)
     */
    public void pop(){
        if(!esPilaVacia()){
            tope = tope.getSiguiente();
            tamaño--;
        }
    }
    
    
    /**
     * TOP nos devuelve la letra correspondiente al tope de la pila
     * @return la letra que está en el tope de la pila
     * @throws NullPointerException 
     */
    public char top() throws NullPointerException {
        if(!esPilaVacia()){
            return tope.getLetra();
        }else{
            //Si la pila es vacia, entonces lanzo una excepción.
            throw new NullPointerException();
        }
    }
    
    /**
     * Muestra todos los elementos de la pila en forma de lista simplemente enlazada.
     * No pertenece al ADT de Pila pero lo necesito para saber si los otros métodos funcionan correctamente.
     */
    public void mostrar() {
        Nodo aux;
        aux = tope;
        while (aux != null) {
            System.out.print(aux.getLetra() + "->");
            aux = aux.getSiguiente();
        }
        System.out.println("NULL");
    }
}
