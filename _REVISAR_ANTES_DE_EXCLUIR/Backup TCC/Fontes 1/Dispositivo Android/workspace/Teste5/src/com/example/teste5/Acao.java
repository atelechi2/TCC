package com.example.teste5;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Acao 
{
final String ipServidor = "192.168.0.103";
final String portaServidor = "12345";
//Estado da lampada
public Boolean count1 = false;
public Boolean count2 = false;
public Boolean count3 = false;
	public void Acao(int botao) 
	{
	//Pino 13
	final String desligaPorta13 = "Q";
	final String ligaPorta13 = "W";
	String x = null;
	try 
		{
		Socket cliente = new Socket(ipServidor, Integer.parseInt(portaServidor));
		
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		
		if(count1)
			{
			saida.println(ligaPorta13);
	    	count1 = false;
			}
		else
			{
	    	saida.println(desligaPorta13);
			count1 = true;
			}
		//Retorno Servidor
        Scanner mensagemServer = new Scanner(cliente.getInputStream());
			while(mensagemServer.hasNext())
				{	
				x = mensagemServer.nextLine();
				if(x.equals("W"))
					{
			//		checkSlot1.setChecked(true);
			//		checkSlot1.setText("on");
					}
				if(x.equals("Q"))
					{
				//	checkSlot1.setChecked(false);
			//		checkSlot1.setText("off");								
					}
          //     	textField.setText(x);
                }
		//Fecha entidades
		mensagemServer.close();
		cliente.close();   //closing the connection
		saida.close();
		}
	catch (UnknownHostException e) 
		{
	//	textField.setText(e.getMessage());
		e.printStackTrace();
		}
	catch (IOException e)
		{
	//	textField.setText(e.getMessage());
		e.printStackTrace();
		}
	catch (Exception e) 
		{
	//	textField.setText(e.getMessage());
		e.printStackTrace();
		}
	}
}
