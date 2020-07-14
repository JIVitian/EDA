/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Fila.Fila;
import Fila.Peticion;
import java.util.Random;

/**
 *
 * @author Ivan
 */
public class Servidor {
    private final int TIEMPO_TOTAL;
    private final int probabilidadIngreso;
    private final int probabilidadPrioridad;
    private int c;
    private final Fila<Peticion> filaPrioridad;
    private final Fila<Peticion> filaComun;
    private int enCurso;
    private int esperaMaximoPrioridad;
    private int esperaMaximoComun;
    private int tiempoInactivo;
    private final Random rand;//Variable auxiliar para tener una variable random
    private int peticiones;//Total de peticiones en el servidor
    private int prioritarias;//Total de peticiones prioritarias ingresadas
    private int comunes;//Total de peticiones comunes ingresadas en el servidor
    private int peticionesAtendidas;
    private int prioritariasAtendidas;
    private int comunesAtendidas;
    private int tamMaxPrioritarias;
    private int tamMaxComunes;

    /**
     * Constructor de la clase que recibe el tiempo que durará la simulación.
     * @param TIEMPO_TOTAL 
     * @param probabilidadIngreso 
     * @param probabilidadPrioridad 
     */
    public Servidor(int TIEMPO_TOTAL, int probabilidadIngreso, int probabilidadPrioridad) {
        this.TIEMPO_TOTAL = TIEMPO_TOTAL;
        this.probabilidadIngreso = probabilidadIngreso;
        this.probabilidadPrioridad = probabilidadPrioridad;
        this.tiempoInactivo = 0;
        this.filaComun = new Fila();
        this.filaPrioridad = new Fila();
        this.rand = new Random();
        this.c = 0;
        this.enCurso = 0;
        this.esperaMaximoComun = 0;
        this.esperaMaximoPrioridad = 0;
        this.peticiones = 0;
        this.prioritarias = 0;
        this.comunes = 0;
        this.peticionesAtendidas = 0;
        this.prioritariasAtendidas = 0;
        this.comunesAtendidas = 0;
        this.tamMaxPrioritarias = 0;
        this.tamMaxComunes = 0;
    }
    
    /**
     * Establece si ingresa o no una petición con una probabilidad calculada de acuerdo a la probabilidad ingresada.
     * @return 
     */
    public boolean ingresaPeticion(){
       return (rand.nextInt(100) <= probabilidadIngreso);
    }
    
    /**
     * Establece si la petición es de un usuario registrado de acuerdo a la probabilidad ingresada.
     * @return 
     */
    public boolean esUsuarioRegistrado(){
        return (rand.nextInt(100) <= probabilidadPrioridad);
    }
    
    /**
     * Crea un objeto Petición con un valor aleatorio entre 50 y 300 para el 
     * atributo tiempo y tiempo_actual para t_in
     * @param x
     * @return una nueva peticion
     */
    public Peticion nuevaPeticion(int x){
        return (new Peticion(x, rand.nextInt(251) + 50));
    }
    
    /**
     * Proceso de simulación
     */
    public void procesar(){
        int espera;
        while(c++ < TIEMPO_TOTAL){
            //Enfilar Peticiones
            if (ingresaPeticion()) {
                Peticion query = nuevaPeticion(c);
                if(esUsuarioRegistrado()){
                    filaPrioridad.enfila(query);
                    prioritarias++;
                    if(tamMaxPrioritarias < filaPrioridad.getTamaño()){
                        tamMaxPrioritarias = filaPrioridad.getTamaño();
                    }
                }
                else{
                    filaComun.enfila(query);
                    comunes++;
                    if(tamMaxComunes < filaComun.getTamaño()){
                        tamMaxComunes = filaComun.getTamaño();
                    }
                }
                peticiones++;
            }
            //Procesar Peticiones
            if(enCurso > 0){
                enCurso--;
            }else{
                if(!filaPrioridad.esFilaVacia()){
                    enCurso = filaPrioridad.frente().getTiempo();
                    espera = c - filaPrioridad.frente().getT_in();
                    if(esperaMaximoPrioridad < espera)
                        esperaMaximoPrioridad = espera;
                    filaPrioridad.defila();
                    prioritariasAtendidas++;
                    peticionesAtendidas++;
                }else{
                    if(!filaComun.esFilaVacia()){
                        enCurso = filaComun.frente().getTiempo();
                        espera = c - filaComun.frente().getT_in();
                        if(esperaMaximoComun < espera)
                            esperaMaximoComun = espera;
                        filaComun.defila();
                        comunesAtendidas++;
                        peticionesAtendidas++;
                    }else
                        tiempoInactivo++;
                }
            }
        }
    }
    
    /**
     * Muestra los resultados de la simulación del servidor
     */
    public void mostrarResultados(){
        System.out.println("Tiempo en el que el procesador estuvo inactivo: " + tiempoInactivo);
        System.out.println();
        System.out.println("Tiempo de máxima espera para las peticiones PRIORITARIAS: " + esperaMaximoPrioridad);
        System.out.println();
        System.out.println("Tiempo de máxima espera para las peticiones COMUNES: " + esperaMaximoComun);
        System.out.println();
        System.out.println("Total de PETICIONES ingresadas: " + peticiones);
        System.out.println();
        System.out.println("Peticiones ATENDIDAS: " + peticionesAtendidas);
        System.out.println();
        System.out.println("Total de PETICIONES PRIORITARIAS ingresadas: " + prioritarias);
        System.out.println();
        System.out.println("PETICIONES PRIORITARIAS ATENDIDAS: " + prioritariasAtendidas);
        System.out.println();
        System.out.println("Total de PETICIONES COMUNES ingresadas: " + comunes);
        System.out.println();
        System.out.println("PETICIONES COMUNES ATENDIDAS: " + comunesAtendidas);
        System.out.println();
        System.out.println("Tamaño máximo de la FILA PRIORITARIA: " + tamMaxPrioritarias);
        System.out.println();
        System.out.println("Tamaño máximo de la FILA COMÚN: " + tamMaxComunes);
        System.out.println();
        System.out.println("Peticiones PRIORITARIAS sin atender al finalizar la simulación: \nCantidad: " + filaPrioridad.getTamaño());
        System.out.println();
        System.out.println("Peticiones COMUNES sin atender al finalizar la simulación: \nCantidad: " + filaComun.getTamaño());
    }
}
