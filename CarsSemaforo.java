package Locadora;
/**
 *
 * @author Danilo
 */


import java.util.concurrent.Semaphore;

public class CarsSemaforo {


    static Semaphore semaphore = new Semaphore(3);

    static class PessoaThread extends Thread {

        String name = "";

        PessoaThread(String name) {
            this.name = name;
        }

        public void run() {

            try {

                
                System.out.println(name + " : Adquirindo Chave...");
                System.out.println(name + " : Semaforo disponível agora: " 
                                + semaphore.availablePermits());
                
                semaphore.acquire();
                System.out.println(name + " : Obteve licença!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : está realizando a operação  " + i 
                                + ", licenças de semáforo disponíveis  "
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
    
        PessoaThread t1 = new PessoaThread("Pessoa 01");
        t1.start();

        PessoaThread t2 = new PessoaThread("Pessoa 02");
        t2.start();

        PessoaThread t3 = new PessoaThread("Pessoa 03");
        t3.start();

        PessoaThread t4 = new PessoaThread("Pessoa 04");
        t4.start();
        
        PessoaThread t5 = new PessoaThread("Pessoa 05");
        t5.start();
        
        PessoaThread t6 = new PessoaThread("Pessoa 06");
        t6.start();
    }
}