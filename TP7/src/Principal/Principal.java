/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import ListaCircular.ListaCircular;

/**
 *
 * @author danie
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaCircular<Integer> lista = new ListaCircular<>();
        lista.LCInsertar(1);
        lista.LCInsertar(2);
        lista.LCInsertar(3);
        lista.LCInsertar(4);
        lista.LCInsertar(5);
        lista.LCInsertar(6);
        lista.LCInsertar(7);
        lista.LCInsertar(8);
        lista.LCInsertar(9);
        lista.LCInsertar(10);
        
        lista.mostrar();
    }
    
}
