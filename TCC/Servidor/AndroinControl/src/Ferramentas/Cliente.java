/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ferramentas;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Atelechi
 */
public class Cliente 
    {
    public static void main(String[] args) throws UnknownHostException, IOException 
        {
        Scanner teclado = new Scanner(System.in);    
        while (teclado.hasNextLine()) 
                {
                Socket cliente = new Socket("127.0.0.1", 12345);
                System.out.println("interação com o servidor!");
                PrintStream saida = new PrintStream(cliente.getOutputStream());
                
                saida.println(teclado.nextLine());
                cliente.close();
                saida.close();
                }
            teclado.close();
        }
    }
