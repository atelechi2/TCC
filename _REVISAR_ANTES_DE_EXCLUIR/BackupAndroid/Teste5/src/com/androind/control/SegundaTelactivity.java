package com.androind.control;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.math.*;

import com.example.teste5.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SegundaTelactivity extends Activity {
	
	final String ipServidor = "192.168.0.103";
	final String portaServidor = "12345";
	int delay = 60;
	int delayBuffer = 60;
	
	
	
	public void onCreate(Bundle savedInstanceState) 
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_segundatela);//main);

	Button Buttonvolta = (Button) findViewById(R.id.buttonBack);   //reference to the back button
	Button Buttonsalvar = (Button) findViewById(R.id.buttonSalvar);   //reference to the save button
	
	final CheckBox ativaRefresh = (CheckBox) findViewById(R.id.checkBox1); 
	
	final TextView porcentagem = (TextView) findViewById(R.id.textView2);
	
	final SeekBar barra1 = (SeekBar) findViewById(R.id.seekBar1);
	final SeekBar barra2 = (SeekBar) findViewById(R.id.seekBar2);
	//Desabilita a barra de Refresh
	barra1.setProgress(0);
	barra1.setEnabled(false);
	//Habilita a barra do Dimmer
	barra2.setProgress(100);
	
	
	
	
	Buttonvolta.setOnClickListener(new View.OnClickListener() 
				{
				public void onClick(View v) 
					{
	//*************************************************************************************
					Intent intent = new Intent();
					intent.setClass(SegundaTelactivity.this,MainActivity.class);
	                startActivity(intent);
	                finish();
	//*************************************************************************************
	              
					}
				});

//********************************* Ativar desativar Check ativaRefresh ****************************************************
	ativaRefresh.setOnClickListener(new View.OnClickListener() 
		{
		public void onClick(View v) 
			{
			if(ativaRefresh.isChecked())
				{
				delay = delayBuffer;
				barra1.setEnabled(true);
				barra1.setProgress((int) (delay/0.6)+1); //+1 porque o arredondamento normalmente diminuia um minuto
				porcentagem.setText(delay +" Minutos");
				}
			else
				{
				delayBuffer = delay;
				 barra1.setEnabled(false);
				 barra1.setProgress(0);
				 porcentagem.setText("Atualização desabilitada");				
				}
			}
		});
//********************************* Botao Salvar ****************************************************
	Buttonsalvar.setOnClickListener(new View.OnClickListener() 
	{
	public void onClick(View v) 
		{
		
		Intent intent = new Intent();
		
		if(ativaRefresh.isChecked())//Verifica se check foi acionado, se foi executa a ação da thread 
 			{
			if(delay==0)
				{
				delay=1;
				}
			intent.putExtra("delay", delay);  
 			}
//******************************* Volta para a primeira Tela **************************************
		
		intent.setClass(SegundaTelactivity.this,MainActivity.class);
        startActivity(intent);
        finish();
		}
	});
	
//*********************************** Primeira barra ****************************************	
	 SeekBar volumeControl = (SeekBar) findViewById(R.id.seekBar1);
	 
     volumeControl.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
         int progressChanged = 0;

         public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
         	{
             progressChanged = progress;
         	if(ativaRefresh.isChecked())
         		{            	 
            	 double tempo = progressChanged;
            	 delay = (int) (tempo*0.6);
            	 if(delay==0)
            		 {
            		 delay = 1;
            		 }
            	 porcentagem.setText(delay+" Minutos");
            	}
         }

         public void onStartTrackingTouch(SeekBar seekBar) {
             // TODO Auto-generated method stub
         }

		@Override
		public void onStopTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}
     });
	
	
   //*****************************Segunda Barra**********************************************	
   	 SeekBar Dimmer = (SeekBar) findViewById(R.id.seekBar2);
   	 
        Dimmer.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progressChanged = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                progressChanged = progress;
                
//********************************************************************************
                String x = null;
				try 
					{
					Socket cliente = new Socket(ipServidor, Integer.parseInt(portaServidor));
					PrintStream saida = new PrintStream(cliente.getOutputStream());
					String DIM = "D"+progressChanged;
					saida.println(DIM);
					//Retorno Servidor
					/* Scanner mensagemServer = new Scanner(cliente.getInputStream());
						while(mensagemServer.hasNext())
							{								
							x = mensagemServer.nextLine();
							feed(x);
	                    	}*/
					//Fecha entidades
					//	mensagemServer.close();
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
				///	textField.setText(e.getMessage());
					e.printStackTrace();
					}
				catch (Exception e) 
					{
				//	textField.setText(e.getMessage());
					e.printStackTrace();
					}
				}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}                
        });
   
   //*************************************************************************	
        
	} 
        
     
	
}
