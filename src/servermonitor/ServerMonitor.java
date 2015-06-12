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





/**
 *
 * @author daniel
 */
public class ServerMonitor {
   
 public static void main(String[] args) throws IOException, ClassNotFoundException  {
       
     FrmMonitor frm = new FrmMonitor();
    frm.setVisible(true);
     
     String mensagem ="";

     ServerSocket servidor = new ServerSocket(12345);
     System.out.println("Porta 12345 aberta!");
     
     Socket connection= servidor.accept();
     System.out.println("Nova conexão com o cliente " +   
       connection.getInetAddress().getHostAddress());
     
     ObjectInputStream entrada = new ObjectInputStream(connection.getInputStream());
     
     do{
         mensagem = (String) entrada.readObject();
         
     } while (!mensagem.equals("Cliente: Encerrar"));
     
     
     
     entrada.close();
     servidor.close();
   }
 }

     

   
   


   
       
