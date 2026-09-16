package com.example.teste5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaTelactivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) 
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_segundatela);//main);
	Button Buttonvolta = (Button) findViewById(R.id.buttonBack);   //reference to the send button
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

		}
	
}
