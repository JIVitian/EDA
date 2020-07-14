/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Morse;

import ArbolB.ArbolB;
import static ArbolB.ArbolB.arbolVacio;
import static ArbolB.ArbolB.armarAB;

/**
 * Clase dedicada a desarrollar todo lo relacionado al codigo morse con Arbol Binario.
 * @author Iván
 */
public class Morse {
    
    /**
     * Metodo que forma un arbol binario desde la raíz hasta las hojas.
     * @param arbol arbol a llenar
     * @param codigo codigo morse
     * @param caracter caracter al que corresponde el codigo
     * @return Arbol que modela el codigo morse
     */
    public ArbolB<Character> insertarMorse(ArbolB<Character> arbol, String codigo, Character caracter) {
        if (arbol.esABVacio()) {
            //Para evitar el NullPointerException.
            arbol = armarAB(arbolVacio(), ' ', arbolVacio());
        }
        
        if (codigo.isEmpty()) {
            //CASO BASE: La recursión se detiene cuando no hay mas caracteres en el String.
            return armarAB(arbolVacio(), caracter, arbolVacio());
        } else {
            if (codigo.startsWith(".")) {
                return armarAB(insertarMorse(arbol.izquierdo(), codigo.substring(1), caracter), arbol.raiz(), arbol.derecho());
            }
            if(codigo.startsWith("-")) {
                return armarAB(arbol.izquierdo(), arbol.raiz(), insertarMorse(arbol.derecho(), codigo.substring(1), caracter));
            } else {
                //Si el codigo morse no tiene un punto o una raya el arbol no se modifica.
                return arbol;
            }
        }
    }
    
    /**
     * Traduce letras en codigo morse a letras.
     * @param arbol Arbol que modela el codigo
     * @param codigo codigo a traducir
     * @return Letra traducida
     */
    public String decodificarCaracterMorse(ArbolB<Character> arbol, String codigo) {
        if (codigo.isEmpty()) {
            //CASO BASE
            return arbol.raiz().toString();
        } else {
            if (codigo.startsWith(".")) {
                return decodificarCaracterMorse(arbol.izquierdo(), codigo.substring(1));
            }
            if (codigo.startsWith("-")) {
                return decodificarCaracterMorse(arbol.derecho(), codigo.substring(1));
            } else {
                //Si el caracter leído no es ni punto ni coma, el algoritmo lo ignora.
                return decodificarCaracterMorse(arbol, codigo.substring(1));
            }
        }
    }
    
    /**
     * Traduce el codigo morse a palabras.
     * El codigo puede ser ingresado separando la información de cada letra separada por un espacio.
     * @param arbol arbol con el codigo morse
     * @param codigo codigo a traducir
     * @return Palabra traducida
     */
    public String decodificarPalabraMorse(ArbolB<Character> arbol, String codigo){
        String[] subCodigos;
        String palabra = "";
        
        if(!codigo.isEmpty()) {
            //Separo el codigo ingresado en varios strings separados por espacios.
            subCodigos = codigo.split(" ");
            for(String subCodigo : subCodigos){
                //Concateno las letras decodificadas para formar una palabra.
                palabra = palabra + decodificarCaracterMorse(arbol, subCodigo);
            }
            return palabra;
        } else {
            //Si no hay nada en codigo Morse, entonces solo devuelvo una String Vacia.
            return "";
        }
    }
    
    /**
     * Carga el modelo del Codigo Morse en un arbol.
     * @param arbol arbol que contendra la información.
     * @return arbol modificado
     */
    public ArbolB<Character> llenarMorse(ArbolB<Character> arbol){
        //RAMA IZQUIERDA
        arbol = insertarMorse(arbol, ".", 'E');
        arbol = insertarMorse(arbol, "..", 'I');
        arbol = insertarMorse(arbol, "...", 'S');
        arbol = insertarMorse(arbol, "....", 'H');
        arbol = insertarMorse(arbol, ".....", '5');
        arbol = insertarMorse(arbol, "....-", '4');
        arbol = insertarMorse(arbol, "...-", 'V');
        arbol = insertarMorse(arbol, "...--", '3');
        arbol = insertarMorse(arbol, "..-", 'U');
        arbol = insertarMorse(arbol, "..-.", 'F');
        arbol = insertarMorse(arbol, "..--", ' ');
        arbol = insertarMorse(arbol, "..---", '2');
        arbol = insertarMorse(arbol, ".-", 'A');
        arbol = insertarMorse(arbol, ".-.", 'R');
        arbol = insertarMorse(arbol, ".-.-", ' ');
        arbol = insertarMorse(arbol, ".-.-.", '+');
        arbol = insertarMorse(arbol, ".-..", 'L');
        arbol = insertarMorse(arbol, ".--", 'W');
        arbol = insertarMorse(arbol, ".--.", 'P');
        arbol = insertarMorse(arbol, ".---", 'J');
        arbol = insertarMorse(arbol, ".----", '1');
        
        //RAMA DERECHA
        arbol = insertarMorse(arbol, "-", 'T');
        arbol = insertarMorse(arbol, "-.", 'N');
        arbol = insertarMorse(arbol, "-..", 'D');
        arbol = insertarMorse(arbol, "-...", 'B');
        arbol = insertarMorse(arbol, "-....", '6');
        arbol = insertarMorse(arbol, "-...-", '=');
        arbol = insertarMorse(arbol, "-..-", 'X');
        arbol = insertarMorse(arbol, "-..-.", '/');
        arbol = insertarMorse(arbol, "-.-", 'K');
        arbol = insertarMorse(arbol, "-.-.", 'C');
        arbol = insertarMorse(arbol, "-.--", 'Y');
        arbol = insertarMorse(arbol, "--", 'M');
        arbol = insertarMorse(arbol, "--.", 'G');
        arbol = insertarMorse(arbol, "---", 'O');
        arbol = insertarMorse(arbol, "--..", 'Z');
        arbol = insertarMorse(arbol, "--...", '7');
        arbol = insertarMorse(arbol, "--.-", 'Q');
        arbol = insertarMorse(arbol, "---.", ' ');
        arbol = insertarMorse(arbol, "----", ' ');
        arbol = insertarMorse(arbol, "---..", '8');
        arbol = insertarMorse(arbol, "----.", '9');
        arbol = insertarMorse(arbol, "-----", '0');
        
        return arbol;
    }
}
