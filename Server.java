import java.net.*;
import java.io.*;
public class Server {   
    public static void main (String args []) {     
        Socket client;
        ServerSocket server;    
        try {    
            server = new ServerSocket(5000);      
            while (true) {      
                System.out.println ("Esperando conexão de cliente!");                           
                client = server.accept();      
                System.out.println ("Cliente se conectando.");     
                InputStream in = client.getInputStream (); // obtendo stream de entrada       
                BufferedReader entrada = new BufferedReader (new InputStreamReader (in)); 
                boolean done = false;      
                while (!done) {        
                    String str = entrada.readLine();

                    if (str==null || str.equals("BYE"))  {

                        done = true; // conexão foi finalizada pelo cliente           
                        System.out.println ("Conexão finalizada.");         
                    }         
                    else System.out.println ("Recebeu: "+str);       
                }       
                client.close();  
            }
        }     
        catch (IOException ioe){ 
            System.out.println ("Erro ao aceitar conexao cliente. Erro: "+ioe); 
        }    
    }  
}