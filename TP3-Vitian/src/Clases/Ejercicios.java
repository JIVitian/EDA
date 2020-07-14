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
public class Ejercicios {
    /**
     * 2. Diseñe una función recursiva llamada DigitoAusente, que determine si un dígito D NO
     * PERTENECE al número dado.
     * Ej: N=1323 D=5 retorna VERDADERO
     * N=35 D=5 retorna FALSO
     * @param numero número que se analizará
     * @param digito número que se verificará dentro del número
     * @return true si el digito no se encuentra en el numero, en caso contrario false
     */
    public boolean digitoAusente(int numero, int digito){
        if(digito < 0 || digito > 9){ //El digito debe tener una sola cifra
            return true;
        }else{
            if(numero < 0){ //Convierto el número a positivo para que el resto de la división sea positivo
                numero = numero*(-1);
            }else{
                if(numero == 0 && digito == 0){ //Si el numero ingresado es 0 y el dígito tambien, entonces el digito si está en el numero
                    return false;
                }else{
                    if(numero % 10 == digito){ //Comparo digito por digito y verifico que el numero no sea 0
                        return false;
                    }else{
                        if(numero / 10 != 0){ //El numero será 0 cuando ya no se pueda dividir siendo entero
                            return digitoAusente(numero/10, digito);
                        }
                    }
                }
            }
        }
        return true; //resultado por defecto
    }
    
    /**
     *4.Escriba una función recursiva sumatoriaPares, que devuelva la suma de los elementos pares de la lista. 
     * Por ejemplo: 1 -> 2 -> 3 -> 4 -> 5  debe retornar 6
     * @param list lista ingresado por el usuario
     * @param nodo el nodo en el que se encontramos
     * @return La sumatoria de los numeros pares de la lista
     */
    private int sumatoriaPares(Lista list, Nodo nodo){
        if (list.estaVacia()) {
            return 0;
        } else {
            if (nodo == null) {
                return 0;
            } else {
                if (nodo.getDato() % 2 == 0) {
                    return (nodo.getDato() + sumatoriaPares(list, nodo.getSiguiente()));
                } else {
                    return (sumatoriaPares(list, nodo.getSiguiente()));
                }
            }
        }
    }
    
    public int sumatoriaPares(Lista list){
        return sumatoriaPares(list, list.getPrimero());
    }
    
    /**
     * 6.Dado un vector ordenado v de n números enteros, escriba un algoritmo D&C buscaPar,
     * que compruebe si el par de enteros x,y ocupa o no posiciones consecutivas en el mismo.
     * El método debe retornar true si x e y son contiguos y false en caso contrario. 
     * @param v
     * @param x
     * @param y
     * @param superior
     * @return Sum
     */
    private boolean buscaPar(int[] v, int x, int y, int superior) throws ArrayIndexOutOfBoundsException { //Se supone que debo recibir el vector ya ordenado
        int inferior = 1;
        int medio;

        while (inferior <= superior) {
            medio = (superior + inferior) / 2;
            if (x == v[medio] || y == v[medio]) { //Alguno de los datos está en el medio
                if (x == v[medio - 1] || y == v[medio - 1] || x == v[medio + 1] || y == v[medio + 1]) { //compruebo todos los casos porque no se si el que está en el medio es x o y
                    return true;
                } else {
                    return false;
                }
            } else {
                if (x < v[medio] && y < v[medio]) {
                    superior = medio - 1;
                } else {
                    inferior = medio + 1;
                }
            }
        }
        return false;
    }
   
    public boolean buscaPar(int[] v, int x, int y){ //El usuario no tiene que ingresar la longitud del vector
        try {
            return buscaPar(v, x, y, v.length);
        } catch (ArrayIndexOutOfBoundsException e) { //si alguno de los datos ingresados no está en el vector, retorno falso pues es valido decir que x e y no estan contiguos
            return false;
        }
    }
    
    public void ordenarVector(int[] vector){ //Ordeno los elementos por si se necesitara, aunque los elementos ya deberían entrar a ordenados a la funcion buscaPar
        int pivote;
        
        System.out.println("Original: ");
        for(int i = 0 ; i < vector.length ; i++){
            System.out.println(vector[i]);
        }
        for(int i = 0 ; i < vector.length ; i++){
            for(int j = i + 1 ; j < vector.length ; j++){
                if(vector[j] <= vector[i]){
                    pivote = vector[i];
                    vector[i] = vector[j]; 
                    vector[j] = pivote;
                }
            }
        }
        System.out.println("Ordenado");
        for(int i = 0 ; i < vector.length ; i++){
            System.out.println(vector[i]);
        }
    }
    
    private int obtenerPosicion(int[] vector, int x) throws ArrayIndexOutOfBoundsException{ //Por si necesitase encontrar la posicion de algun elemento e un vector
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == x) {
                return i;
            }
        }
        return vector.length;
    }
}
