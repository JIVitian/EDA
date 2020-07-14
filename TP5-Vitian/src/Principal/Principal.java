/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Pila.Pila;

/**
 *
 * @author Iván
 */
public class Principal { 
    public static void main(String[] args) {    
        Pila pila = new Pila();
    
        System.out.println("Ingreso un valor para el tope de la pila:");
        pila.push('a');
        
        pila.mostrar();
        
        System.out.println("\nVerifico el tope:");
        System.out.println(pila.top());
        
        System.out.println("\nSaco el tope de la pila:");
        pila.pop();
        
        pila.mostrar();
        
        System.out.println("\nPruebo que NO se modifique la pila por estar vacia:");
        pila.pop();

        System.out.println("\nDeberia lanzar una excepción por sacar el tope de una pila vacia:");
        System.out.println(pila.top());

        //Agrego mas elementos a la pila para ver que todo funcione bien
//        pila.push('b');
//        pila.push('c');
//        pila.push('d');
//        
//        pila.mostrar();
//        
//        pila.pop();
//        
//        pila.mostrar();
    }
}
