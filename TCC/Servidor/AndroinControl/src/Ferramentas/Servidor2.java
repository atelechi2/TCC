/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ferramentas;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import serialcom.SerialComLeitura;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;


public class Servidor2 
    {
    
//----------------------------------------main-----------------------------------------------------------------------    
    public static void main(String[] args) throws IOException, Exception 
        {
        String x = null;
        try 
            {
            //Arduino  
            SerialComLeitura serialEscrita = new SerialComLeitura("COM7", 9600, 0);//Essa com deve vir do banco
            System.out.println("AUTO TESTE");
            serialEscrita.HabilitarEscrita();
            serialEscrita.ObterIdDaPorta();
            serialEscrita.AbrirPorta();
            serialEscrita.EnviarUmaString("W");
            serialEscrita.EnviarUmaString("Q");
            serialEscrita.FecharCom(); 
            Toolkit.getDefaultToolkit().beep();
            while(true)
                {
                ServerSocket servidor = new ServerSocket(12345);//Esta porta deve vir do banco
                Socket cliente = servidor.accept();
                String ipCliente = cliente.getInetAddress().getHostAddress();
                //ToDo - Negação de ip desconhecido
                //if(ipCliente.equalsIgnoreCase("ip1"))
                //Mensagem mostrando qual cliente se conectou (ToDo Auditoria)
                System.out.println("Interação com cliente " + cliente.getInetAddress().getHostAddress());
                Scanner s = new Scanner(cliente.getInputStream());
                if(s.hasNext()) 
                    {
                    //Recebe dado do Cliente
                    x = s.nextLine();
                    //Envia dado para Arduino
                    serialEscrita.HabilitarEscrita();
                    serialEscrita.ObterIdDaPorta();
                    serialEscrita.AbrirPorta();
                    serialEscrita.EnviarUmaString(x);
                    serialEscrita.FecharCom();
                    Toolkit.getDefaultToolkit().beep();
                    }             
               //Envia estado das lampadas para clientes                
               PrintStream feedback = new PrintStream(cliente.getOutputStream()); 
               feedback.println(x);    
               //Fecha entidades
                servidor.close();
                cliente.close();
                s.close();
                feedback.close();
                }
            } 
        catch (Exception e) 
                {
                System.out.println("Erro: "+e);
                }
        }
    }
