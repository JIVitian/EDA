/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedSocial;

/**
 *
 * @author Ivan
 */
public class RedSocial {
    
    private Nodo primero;
    private int longitud;

    public RedSocial() {
        this.longitud = 0;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }
    
    public boolean esVacia(){
        return longitud == 0;
    }
    
    private boolean esta(int usuario, Nodo nodo){
        if(nodo == null){
            return false;
        }else{
            return (nodo.getUsuario() == usuario || esta(usuario, nodo.getSiguiente()));
        }
    }
    
    public boolean esta(int usuario){
        return (esta(usuario, primero));
    }
    
    public void echar(int usuario){
        if(longitud >= 1){
            echar(usuario, primero, primero);
        }
    }
    
    private void echar(int usuario,Nodo anterior, Nodo nodo){
        if(nodo != null){
            if (nodo.getUsuario() == usuario) {
                if(anterior == primero){ //Solo para el caso en el que el nodo a eliminar es el primero en la lista o el ultimo ingresado
                    primero = primero.getSiguiente();
                    longitud--;
                    echar(usuario, primero.getSiguiente(), primero.getSiguiente().getSiguiente());
                }else{
                    anterior.setSiguiente(nodo.getSiguiente());
                    longitud--;
                    echar(usuario, anterior, nodo.getSiguiente());
                }
            }else{
                if(nodo == primero){ //Solo para la primera recursión
                    echar(usuario, primero, primero.getSiguiente());
                }else{
                echar(usuario, anterior.getSiguiente(), nodo.getSiguiente());
                }
            }
        }
    }
    
    public void registrar(int usuario) {
        Nodo aux = new Nodo(usuario);
        aux.setSiguiente(this.primero);
        this.primero = aux;
        longitud++;
    }
    
    public void mostrar() {
        Nodo aux;
        aux = primero;
        while (aux != null) {
            System.out.print(aux.getUsuario() + "->");
            aux = aux.getSiguiente();
        }
        System.out.println("NULL");
    }
    
    public Integer ultimoUsuario(){ //El ultimo usuario ingresado es el primero en la lista
        if(primero != null){
            return primero.getUsuario();
        }
        return null; //Tira excepcion si la lista está vacia
    }
    
    public int cantidad(){
        return longitud;
    }
    
}   
