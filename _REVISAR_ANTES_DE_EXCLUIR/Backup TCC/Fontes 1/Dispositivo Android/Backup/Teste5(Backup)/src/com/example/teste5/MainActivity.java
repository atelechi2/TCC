package com.example.teste5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

	private Socket client;
//	private PrintWriter printwriter;
	private EditText textField;
	private Button button1;
	public Boolean count = true;
	final String ipServidor = "192.168.0.103";
	final String portaServidor = "12345";
	@Override
	public void onCreate(Bundle savedInstanceState) 
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);//main);

		textField = (EditText) findViewById(R.id.editText1); //reference to the text field
		button1 = (Button) findViewById(R.id.button1);   //reference to the send button
		final String messsageLiga = "L";
		final String messsageDesliga = "D";
		final String m = "teste";
		//Button press event listener
		button1.setOnClickListener(new View.OnClickListener() 
			{
			public void onClick(View v) 
				{
     
				textField.setText("");//Reset the text field to blank
				try 
					{
					textField.setText("");
					Socket cliente = new Socket(ipServidor, Integer.parseInt(portaServidor));
					
					PrintStream saida = new PrintStream(cliente.getOutputStream());
					
					if(count)
						{
						textField.setText(messsageLiga);
						saida.println(messsageLiga);
				    	
				    	count = false;
						}
					else
						{
						
						textField.setText(messsageDesliga);
				    	saida.println(messsageDesliga);
						count = true;
						}
				boolean in = true;
			/*	ObjectInputStream mensagemServer;
                mensagemServer = new ObjectInputStream(cliente.getInputStream());
					while(in)
						{						
	                    if(mensagemServer.read()!=1000)
	                    	{
	                    	String var = String.valueOf(mensagemServer.read());
	                    	textField.setText(var);
	                    	in=false;
	                    	}
						}*/
					cliente.close();   //closing the connection
					}
				catch (UnknownHostException e) 
					{
					textField.setText(e.getMessage());
					e.printStackTrace();
					}
				catch (IOException e)
					{
					textField.setText(e.getMessage());
					e.printStackTrace();
					}
				catch (Exception e) 
					{
					textField.setText(e.getMessage());
					e.printStackTrace();
					}
				}
			});

	
	Button Buttonvatela = (Button) findViewById(R.id.button2);   //reference to the send button
	Buttonvatela.setOnClickListener(new View.OnClickListener() 
				{
				public void onClick(View v) 
					{
	//*************************************************************************************
					Intent intent = new Intent();
					intent.setClass(MainActivity.this,SegundaTelactivity.class);
	                startActivity(intent);
	                finish();
	//*************************************************************************************
	              
					}
				});
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

/*
 package lakj.comspace.simpleclient;


public class SimpleClientActivity extends Activity {




}
 
*/