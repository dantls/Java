import java.net.*;
import java.io.*; 
public class Client {   
    public static final int PORTA = 6000;


    public static void main(String args[]) throws IOException {     
            Socket s1 = new Socket("127.0.0.1", PORTA);
            OutputStream out = s1.getOutputStream (); // obtendo outputstream   
            PrintStream saida = new PrintStream (out);   
            boolean done = false;   
            while (!done) {   
                String str = Console.read (": ");    
                saida.println (str);     
                if (str.equals ("BYE"))
                    done=true;   
            }
            s1.close();    
         
    }
} 

class Console {   
    public static String read (String str) {     
        InputStream in = System.in;     
        InputStreamReader is = new InputStreamReader (in);     
        BufferedReader console  = new BufferedReader (is);     
        System.out.print (str);     
        String name = null;     
        try {       
            name = console.readLine ();     
        }     
        catch (IOException e) { }       
        return name;     
    } 
}