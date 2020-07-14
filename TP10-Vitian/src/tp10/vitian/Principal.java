/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp10.vitian;

/**
 *
 * @author Iván
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arreglo = {36, 909, 100, 25, 101, 49, 64, 471, 381, 471, 381, 4, 555, 186, 100, 38, 671, 1, 10, 999, 899, 2};
        int[] aux = new int[10];
        Radix radix = new Radix();
        
        radix.ordenar(arreglo);

        for (int m = 0 ; m < arreglo.length ; m++) {
            System.out.print(arreglo[m] + "->");
        }
        
        System.out.println("ABC"/10);
    }
    
}
