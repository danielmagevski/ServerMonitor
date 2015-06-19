/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermonitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMonitor {
   
 public static void main(String[] args) throws IOException, ClassNotFoundException  {
       
    //String mensagem ="Inicializando Servidor";
     
     FrmMonitor frm = new FrmMonitor();
     frm.setVisible(true);
     
     //ServerSocket servidor = new ServerSocket(12345);
     //frm.exibir(mensagem);
     frm.escrever("Iniciando Servidor...\n");
     ServerSocket servidor = new ServerSocket(12345);
     
     frm.escrever("Servidor com as portas abertas...\n");
     Socket connection= servidor.accept();
    
    frm.escrever("Nova conexao: "+ connection.getInetAddress().getHostAddress());
        
    //Fluxo de dados, ida e volta 
    InputStream entrada = connection.getInputStream();
    OutputStream saida = connection.getOutputStream();
    
    // Iniciando objetos de fluxo
     BufferedReader in = new BufferedReader(new InputStreamReader(entrada));
     PrintStream out = new PrintStream(saida);
     
     
     while(true){
         String mensagem = in.readLine();
         frm.escrever("cliente: " + mensagem + "\n");
     if ("FIM" .equals(mensagem)){
         frm.escrever("Encerrando servido...");
         break;
     }
     }
 }
}

// System.out.println("Nova conexão com o cliente " +   
      // connection.getInetAddress().getHostAddress());
     
     //ObjectInputStream entrada = new ObjectInputStream(connection.getInputStream());
     
     
    //mensagem = (String) entrada.readObject();
     
    // frm.exibir(mensagem);
     
     //do{
       //  mensagem = (String) entrada.readObject();
         
    // } while (!mensagem.equals("Cliente: Encerrar"));
     
     
     
     //entrada.close();
     //servidor.close();
  // }
 //}

     

   
   


   
       
