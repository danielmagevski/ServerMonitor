package br.com.ServerMonitor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author alunon
 */
public class servermonitor {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
            String mensagem="aaaa";
       //criando o servidor
        //aguardando conexoes
        try (ServerSocket server = new ServerSocket (64000)) {
            //aguardando conexoes
            
            Socket connection = server.accept();
            
            
            
                try (ObjectInputStream entrada = new ObjectInputStream(connection.getInputStream())) {
                    do {
                        mensagem = (String) entrada.readObject();
                    } while (!mensagem.equals("Cliente: Encerrar"));
                }
        }
            
            
           }
                    
    
}
