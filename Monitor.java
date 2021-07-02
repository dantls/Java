/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locadora;

/**
 *
 * @author Danilo
 */

public class Monitor{

    static class Produto {
        private int quantidade = 0;

        public synchronized void adicionar(int valor){
            if(valor >= 0 ){
                quantidade += valor;
            }else{
                System.out.println("Não é possível adicionar valores negativos");
            }
            System.out.println(quantidade);
        }
        public synchronized void retirar(int valor){
            if(valor >= 0 ){
                quantidade -= valor;
            }else{
                System.out.println("Não é possível adicionar valores negativos");
            }
            System.out.println(quantidade);
        }

    }
    
    
    
     public static void main(String[] args) {
         
        Produto p = new Produto();
        p.adicionar(10);
        p.retirar(5);
        
    }


}

