/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermonitor;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMonitor {
   
 public static void main(String[] args) throws IOException, ClassNotFoundException  {
       
    String mensagem ="Inicializando Servidor";
     
     FrmMonitor frm = new FrmMonitor();
     frm.setVisible(true);
     
     ServerSocket servidor = new ServerSocket(12345);
     frm.exibir(mensagem);
      
     
    Socket connection= servidor.accept();
    
    frm.exibir("Nova conexao: "+ connection.getInetAddress().getHostAddress());
        
    // System.out.println("Nova conexão com o cliente " +   
      // connection.getInetAddress().getHostAddress());
     
     ObjectInputStream entrada = new ObjectInputStream(connection.getInputStream());
     
     mensagem = (String) entrada.readObject();
     
     frm.exibir(mensagem);
     
     do{
         mensagem = (String) entrada.readObject();
         
     } while (!mensagem.equals("Cliente: Encerrar"));
     
     
     
     entrada.close();
     servidor.close();
   }
 }

     

   
   


   
       
