package tp10.vitian;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iván
 */
public class Radix {

    public Radix() {
        
    }
    
    
    private int digitos(int[] arreglo){
        int aux = arreglo[0];
        int digitos = 0;
        
        for(int i = 0 ; i < arreglo.length ; i++){
            if(arreglo[i] > aux){
                aux = arreglo[i];
            }
        }
        while(aux != 0){
            aux = aux / 10;
            digitos++;
        }
        return digitos;
    }
    
    public void ordenar(int[] arreglo){
        ordenarNum(arreglo, arreglo.length, digitos(arreglo));
    }
    
    /**
     * Ordena todos los elementos de un arreglo en orden creciente usando el metodo de residuos.
     * @param arreglo
     * @param tamaño
     * @param digitos 
     */
    public void ordenarNum(int[] arreglo, int tamaño, int digitos){
        Fila<Integer>[] fila = new Fila[10];
        int div = 1;
        int pos;
        
        //Inicializa las filas para poder usarlas
        for(int x = 0 ; x < 10 ; x++){
            fila[x] = new Fila();
        }
        
        //Recorro el Arreglo
        for (int i = 0 ; i < digitos ; i++) {
            //Pongo en las filas los números segun el digito
            for (int j = 0 ; j < tamaño ; j++) {
                //div = 1 y se va multiplicando por 10 cada vez que itero nuevamente, ésto para disminuir en tantos digitos como 0 tenga el div
                //div crece a razón de 10^i
                fila[(arreglo[j]/div)%10].enfila(arreglo[j]);
                //El %10 sirve para tomar el ultimo digito de mi número, ubico ese digito en el indice de la fila a la que corresponde y
                //enfilo el número completo en la misma
            }
            //Este for es solo para ver el contenido de las filas
            for (int k = 0 ; k < 10 ; k++) {
                System.out.print("Fila " + k + ": ");
                fila[k].mostrar();
            }
            //La posición del arreglo debe ser 0 cada vez que rearmo el arreglo
            pos = 0;
            //Reordeno el arreglo con el contenido de las filas de la primera a la ultima
            for (int l = 0 ; l < 10 ; l++) {
                while (!fila[l].esFilaVacia()) {
                    arreglo[pos] = fila[l].frente();
                    pos++;
                    fila[l].defila();
                }
            }
            //Multiplico por 10 el div
            div *= 10;
        }
    }

    public void ordenarChar(char[] arreglo){
        
    }
    
    public void ordenarChar(char[] arreglo, int tamaño, int digitos){
        
    }
}
