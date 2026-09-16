/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ferramentas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import serialcom.SerialComLeitura;

/**
 *
 * @author Atelechi
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
//----------------------------------------main-----------------------------------------------------------------------    
    public static void main(String[] args) throws IOException, Exception {
        try {

            while(true)
            {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Porta 12345 aberta!");

            Socket cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

            Scanner s = new Scanner(cliente.getInputStream());
            SerialComLeitura serialEscrita = new SerialComLeitura("COM9", 9600, 0);
            
            if(s.hasNext()) {
                String x = s.nextLine();
                System.out.println("dado recebido: " + x);


                //Arduino

                serialEscrita.HabilitarEscrita();

                serialEscrita.ObterIdDaPorta();

                serialEscrita.AbrirPorta();

                serialEscrita.EnviarUmaString(x);

                serialEscrita.FecharCom();
                System.out.println(x);

            }
            // 
            s.close();
            servidor.close();
            cliente.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
