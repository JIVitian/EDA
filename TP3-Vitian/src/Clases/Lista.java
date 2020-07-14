/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Iván
 */
public class Lista {

    private Nodo primero;
    private int longitud = 0;//Ésta variable representa la cantidad de nodos que posee la lista y es util para los metodos de la clase

    public Lista() {
        primero = null;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public int getLongitud() {
        return longitud;
    }
    
    public boolean estaVacia() {
        return (longitud == 0);
    }

    public void agregarAlInicio(int dato) {
        Nodo aux = new Nodo(dato);
        aux.setSiguiente(this.primero);
        this.primero = aux;
        longitud++;
    }

    public void agregarAlFinal(int dato) {
        if (estaVacia()) {
            agregarAlInicio(dato);
            longitud++;
        } else {
            Nodo aux;
            aux = primero;
            while (aux != null) {
                if (aux.getSiguiente() == null) {
                    Nodo m = new Nodo(dato);
                    aux.setSiguiente(m);
                    longitud++;
                    break;
                }
                aux = aux.getSiguiente();
            }
        }
    }

    public void mostrar() {
        Nodo aux;
        aux = primero;
        while (aux != null) {
            System.out.print(aux.getDato() + "->");
            aux = aux.getSiguiente();
        }
        System.out.println("NULL");
    }
    
    public void mostrarCantidadNodos() {//El enunciado decia que el metodo debia MOSTRAR la cantidad de nodos.
        System.out.println("Cantidad de Nodos en la lista: " + longitud);
    }
    
    public void eliminarPrimerNodo(){
        primero = primero.getSiguiente();
        longitud--;
    }
    
    public void eliminarUltimoNodo(){
        Nodo aux = primero;

        while(aux != null){
            if(aux.getSiguiente().getSiguiente() == null){
                aux.setSiguiente(null);
                longitud--;
                break;
            }
            aux = aux.getSiguiente();
        }
    }
    
    public void eliminarPorValor(int valor){
        Nodo aux = primero.getSiguiente();
        Nodo anterior = primero;
        
        if (primero.getDato() == valor) {
            eliminarPrimerNodo();
            if(!estaVacia()){
                eliminarPorValor(valor); //Por si hay algun otro nodo que contenga el mismo valor ingresado
            }
        } else {
            while (aux != null) {
                if (aux.getDato() == valor) {
                    if (aux.getSiguiente() != null) { //Si el valor está entre el primer y el ultimo nodo
                        anterior.setSiguiente(aux.getSiguiente());
                        longitud--;
                        if(estaVacia()){//Por si se eliminan todos los nodos de la lista
                            break;
                        }
                        eliminarPorValor(valor);
                        break;
                    } else {//Si el valor se encuentra en el ultimo nodo
                        anterior.setSiguiente(anterior.getSiguiente().getSiguiente());
                        longitud--;
                        break;
                    }
                }
                    anterior = anterior.getSiguiente();
                    aux = aux.getSiguiente();
            }
        }
    }

    public void eliminarPorPosicion(int posicion) {
        Nodo aux;
        Nodo anterior;

        if (estaVacia()) {
            System.out.println("No hay nodos en la lista.");
        } else {
            if (posicion >= 0 && posicion < longitud) {
                int i = 1;
                aux = primero.getSiguiente();
                anterior = primero;

                if (posicion == 0) { //Si la posicion a borrar es el primer nodo
                    if (primero.getSiguiente() != null) { //Si la lista tiene mas de un nodo
                        primero = primero.getSiguiente();
                        longitud--;
                    } else { //Si la lista tiene solo un nodo
                        primero = null;
                        longitud--;
                    }
                } else {
                    while (aux != null) {
                        if (i == posicion) {
                            if (aux.getSiguiente() != null) {
                                anterior.setSiguiente(aux.getSiguiente());
                                longitud--;
                                break;
                            } else {//La posicion ingresada es la ultima
                                anterior.setSiguiente(null);
                                longitud--;
                                break;
                            }
                        }
                        i++;
                        anterior = anterior.getSiguiente();
                        aux = aux.getSiguiente();
                    }
                }
            } else {
                System.out.println("La posición ingresada no es coherente con la cantidad de elemntos de la lista.");
            }
        }
    }
    
    public int obtenerDato(int posicion){
        Nodo aux = primero;
        int i = 0;
             
        if(posicion >= 0 && posicion < longitud){
            while(aux != null){
                if(i == posicion){
                    return aux.getDato();
                }
                i++;
                aux = aux.getSiguiente();
            }
        }else{ //Puse que cuandp la posicion sea incorrecta salte un numero poco probable de elegir
            System.out.println("Posicion ingresada incorrecta."); //Creo que esto se podia evitar no permitiendo que se de este caso
            return -9999; // mediante el uso de una interfaz grafica
        }
        return -9999;
    }
    
    public void modificarNodo(int posicion, int valor){
        Nodo aux;
        Nodo anterior;

        if (estaVacia()) {
            System.out.println("No hay nodos en la lista.");
        } else {
            if (posicion >= 0 && posicion < longitud) {
                int i = 0;
                aux = primero;
                while(aux != null){
                    if(i == posicion){
                        aux.setDato(valor);
                        break;
                    }
                    i++;
                    aux = aux.getSiguiente();
                }
            } else {
                System.out.println("La posición ingresada no es coherente con la cantidad de elemntos de la lista.");
            }
        }
    }
    
    public void agregarNodo(int posicion, int valor){
        Nodo aux;
        Nodo anterior;
        Nodo nuevo = new Nodo(valor);
        
        if (estaVacia()) {
            System.out.println("No hay nodos en la lista.");
        } else {
            if (posicion >= 0 && posicion <= longitud) {
                int i = 1;
                aux = primero.getSiguiente();
                anterior = primero;

                if (posicion == 0) { //Si la posicion del nodo a agregar es la primera
                    agregarAlInicio(valor);
                }
                if (posicion == longitud) { //Si la posicion del nuevo nodo es posterior al ultimo
                    agregarAlFinal(valor);
                } else {
                    while (aux != null) {
                        if (i == posicion) {//Si la posicion del nuevo nodo está entre el primero y el ultimo
                                nuevo.setSiguiente(aux);    //Agrego el nodo entre el anterior al de posicion i y el siguiente
                                anterior.setSiguiente(nuevo);
                                longitud++;
                                break;
                        }
                        i++;
                        anterior = anterior.getSiguiente();
                        aux = aux.getSiguiente();
                    }
                }
            } else {
                System.out.println("La posición ingresada no es coherente con la cantidad de elemntos de la lista.");
            }
        }
    }
    
    public void listaParImpar(Lista listaPar, Lista listaImpar){
        int cantNodos;
        Nodo aux = primero;
        
        while(aux != null){
            if(aux.getDato() % 2 == 0){
                listaPar.agregarAlInicio(aux.getDato());
            }else{
                listaImpar.agregarAlInicio(aux.getDato());
            }
            
            aux = aux.getSiguiente();
        }
    }
}
