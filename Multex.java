package Locadora;

/**
 *
 * @author Danilo
 */


import java.util.concurrent.Semaphore;

public class Multex{

    
    static Semaphore semaphore = new Semaphore(1);

    static class PessoaThread extends Thread {

        String name = "";

        PessoaThread(String name) {
            this.name = name;
        }

        public void run() {

            try {

                System.out.println(name + " : Adquirindo Chave...");
                System.out.println(name + " : Semaforo disponivel agora: " 
                                + semaphore.availablePermits());

                semaphore.acquire();
                System.out.println(name + " : Obteve licença!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : está realizando a operação " + i 
                                + ", licenças de semáforo disponíveis : "
                                + semaphore.availablePermits());

                        
                        Thread.sleep(1000);

                    }

                } finally {

                    
                    System.out.println(name + " : Liberando bloqueio...");
                    semaphore.release();
                    System.out.println(name + " : Licença de semáforo disponiveis agora: " 
                                + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

    public static void main(String[] args) {

         System.out.println("Total de semaforos disponíveis : " 
                + semaphore.availablePermits());
    
        CarsSemaforo.PessoaThread t1 = new CarsSemaforo.PessoaThread("Pessoa 01");
        t1.start();

        CarsSemaforo.PessoaThread t2 = new CarsSemaforo.PessoaThread("Pessoa 02");
        t2.start();

        CarsSemaforo.PessoaThread t3 = new CarsSemaforo.PessoaThread("Pessoa 03");
        t3.start();

        CarsSemaforo.PessoaThread t4 = new CarsSemaforo.PessoaThread("Pessoa 04");
        t4.start();
        
        CarsSemaforo.PessoaThread t5 = new CarsSemaforo.PessoaThread("Pessoa 05");
        t5.start();
        
        CarsSemaforo.PessoaThread t6 = new CarsSemaforo.PessoaThread("Pessoa 06");
        t6.start();

    }
}