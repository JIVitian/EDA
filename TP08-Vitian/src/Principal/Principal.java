/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import ArbolB.ArbolB;
import static ArbolB.ArbolB.arbolVacio;
import Morse.Morse;

/**
 * 
 * @author Iván
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Morse morse = new Morse();
        ArbolB<Character> arbol = arbolVacio();

        
        System.out.println("********************Lleno el arbol con los datos del codigo Morse********************\n");
        arbol = morse.llenarMorse(arbol);
        
        System.out.println("********************Muestro los datos del arbol********************\n");
        System.out.print("Arbol en PreOrden: ");
        arbol.preorden();
        System.out.println();
        
        System.out.print("Arbol en Orden Simetrico: ");
        arbol.inorden();
        System.out.println();
        
        System.out.print("Arbol en PostOrden: ");
        arbol.postorden();
        System.out.println("\n");
        
        System.out.println("(\"********************Pruebo el algoritmo Con la Señal SOS(\"********************\n");
        System.out.println("El mensaje dice: " + morse.decodificarPalabraMorse(arbol, "... --- ...") + "\n");

    }
    
}
