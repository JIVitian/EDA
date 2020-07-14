/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import RedSocial.Nodo;
import RedSocial.RedSocial;

/**
 *
 * @author Ivan
 */
public class Prinicipal {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();
        RedSocial red1 = new RedSocial();
        RedSocial red2 = new RedSocial();
        
        System.out.println(red.esVacia());
        
        red.registrar(1);
        red.registrar(2);
        red.registrar(3);
        red.registrar(4);
        red.registrar(5);
        
        System.out.println(red.esVacia());
        
        red.echar(1);
        
        red.mostrar();

        System.out.println(red.ultimoUsuario());
        
        red1.registrar(1);
        red1.registrar(2);
        red2.registrar(2);
        red2.registrar(3);
       
        System.out.println(esAmigoComun(2, red1, red2));
        System.out.println(esAmigoComun(3, red1, red2));
        
        RedSocial nueva = union(red1,red2);
        
        nueva.mostrar();
    }
    
    private static boolean esAmigoComun(int usuario, RedSocial red1, RedSocial red2){
        return red1.esta(usuario) && red2.esta(usuario);
    }
   
    private static RedSocial union(RedSocial red1, RedSocial red2){
        RedSocial redUnion = new RedSocial();
        Nodo aux1 = red1.getPrimero();
        Nodo aux2 = red2.getPrimero();
        while (aux1 != null) {
            redUnion.registrar(aux1.getUsuario());
            aux1 = aux1.getSiguiente();
        }
        while (aux2 != null) {
            redUnion.registrar(aux2.getUsuario());
            aux2 = aux2.getSiguiente();
        }
        return redUnion;
    }
}
