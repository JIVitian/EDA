/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Clases.Lista;
import Clases.Ejercicios;
import java.util.Scanner;

/**
 *
 * @author Iván
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero;
        int digito;
        int numeros[] = {2, 8, 6, 6, 4, 10, 12};
        Lista list = new Lista();
        Ejercicios prueba = new Ejercicios();
        Scanner miScanner = new Scanner(System.in);
        
        /***********Punto 2************/

        System.out.println("Ingrese un número y un dígito");
        numero = miScanner.nextInt();
        do{
            digito = miScanner.nextInt();
            if(digito < 0 || digito > 9){
                System.out.println("El numero ingresado no es un digito, intentelo de nuevo.");
            }
        }while(digito < 0 || digito > 9);
        
        if(prueba.digitoAusente(numero, digito)){
            System.out.println("El digito no se encuentra en el número ingresado.");
        }else{
            System.out.println("El digito se encuentra en el número ingresado.");
        }

        /***********Punto 4************/

//        list.agregarAlInicio(0);
//        list.agregarAlInicio(1);
//        list.agregarAlInicio(2);
//        list.agregarAlInicio(3);
//        list.agregarAlInicio(4);
//        list.agregarAlInicio(5);
//        list.agregarAlInicio(6);
//        
//        prueba.sumatoriaPares(list);
//
//        System.out.println("La suma de los números pares de la lista ingresada es: " + prueba.sumatoriaPares(list));


        /***********Punto 6************/

/*        System.out.println("El vector se introduce al inicio del codigo, puede cambiarlo si lo desea."); */
//        prueba.ordenarVector(numeros);
//        
//        if(prueba.buscaPar(numeros, 12, 14)){
//            System.out.println("Los elementos están contiguos.");
//        }else{
//            System.out.println("Los elementos no están contiguos.");
//        }
    }
    
}
