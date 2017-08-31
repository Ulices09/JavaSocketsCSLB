package clbss;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream dataInput = new DataInputStream(s.getInputStream());
            DataOutputStream dataOutput = new DataOutputStream(s.getOutputStream());
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msgInput = "", msgOutput = "";
            
            while(!msgInput.equals("terminar")){
                msgInput = dataInput.readUTF();
                System.out.println(msgInput);
                msgOutput = br.readLine();
                dataOutput.writeUTF("Servidor: " + msgOutput);
                dataOutput.flush();
            }
            s.close();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

}
