package clbss;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
    
    public static void main(String[] args) {
        try{
            Balancer balanceador = new Balancer();
            int puerto = balanceador.getServidor();
            Socket s = new Socket("localhost", puerto);
            DataInputStream dataInput = new DataInputStream(s.getInputStream());
            DataOutputStream dataOutput = new DataOutputStream(s.getOutputStream());
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msgInput = "", msgOutput = "";
            
            while(!msgInput.equals("terminar")){
                
                msgOutput = br.readLine();
                dataOutput.writeUTF("Cliente 1 (" + puerto + "): " + msgOutput);
                msgInput = dataInput.readUTF();
                System.out.println(msgInput);
            }
            s.close();
            
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
}
