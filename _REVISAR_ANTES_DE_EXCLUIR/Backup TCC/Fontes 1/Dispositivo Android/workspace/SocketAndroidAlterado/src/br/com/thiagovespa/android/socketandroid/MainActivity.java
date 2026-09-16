package br.com.thiagovespa.android.socketandroid;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity 
	{
	private Button btnSend;
	private TextView txtStatus;
	private TextView txtValor;
	private TextView txtHostPort;
	private SocketTask st;

	@Override
	public void onCreate(Bundle savedInstanceState) 
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnSend = (Button) findViewById(R.id.btnSend);
		txtStatus = (TextView) findViewById(R.id.txtStatus);
		txtValor = (TextView) findViewById(R.id.txtValor);
		txtHostPort = (TextView) findViewById(R.id.txtHostPort);
		btnSend.setOnClickListener(btnConnectListener);
		}

	private OnClickListener btnConnectListener = new OnClickListener() 
		{
		public void onClick(View v) 
			{
			final String host = "192.168.0.103";
			final String port = "12345";
			final String liga ="L";
			// Instancia a classe de conexão com socket
			st = new SocketTask(host, Integer.parseInt(port), 5000) 
				{
				@Override
				protected void onProgressUpdate(String... progress) 
					{
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					// Recupera o retorno
					txtStatus.setText(sdf.format(new Date()) + " - " + progress[0]);
					}
				};
			// Envia os dado
			st.execute(txtValor.getText() == null ? "" : txtValor.getText().toString()); 
			}
		};

	@Override
	protected void onDestroy() 
		{
		super.onDestroy();
		st.cancel(true);
		}
	}