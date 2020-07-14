/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Servidor.Servidor;
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
        Servidor servidor;
        int tiempo;
        int probabilidadIngreso;
        int probabilidadPrioridad;
        Scanner entrada = new Scanner(System.in);

        do{
            System.out.println("Ingrese el tiempo que durará la simulación:");
            tiempo = entrada.nextInt();
        }while(tiempo <= 0);
        
        do{
            System.out.println("Ingrese un numero para calcular la probabilidad que hay de que llegue una petición (probabilidad = numero/100):");
            probabilidadIngreso = entrada.nextInt();
        }while(probabilidadIngreso <= 0 || probabilidadIngreso > 100);
        
        do{
            System.out.println("Ingrese un numero para calcular la probabilidad de que ingrese una petición con prioridad (probabilidad = numero/100): ");
            probabilidadPrioridad = entrada.nextInt();
        }while(probabilidadPrioridad <= 0 || probabilidadPrioridad > 100);
        
        servidor = new Servidor(tiempo, probabilidadIngreso, probabilidadPrioridad);
        
        System.out.println("****************INICIO DE LA SIMULACIÓN****************");
        
        servidor.procesar();
        
        System.out.println("****************FIN DE LA SIMULACIÓN****************");
        
        servidor.mostrarResultados();
    }
    
}
