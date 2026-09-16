/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serialcom;


import gnu.io.CommPortIdentifier;

import gnu.io.SerialPort;

import gnu.io.SerialPortEvent;

import gnu.io.SerialPortEventListener;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.Iterator;







/**
 *
 * @author Atelechi
 */
//public class SerialComLeitura 
public class SerialComLeitura implements Runnable, SerialPortEventListener{

    
    
    //}
    //----------------------------------------------------------------------------------------------------------------

    //Como na classe anterior o primeiro passo é colocar os imports:
    
    //Como pode ser observado vamos também utilizar alguns recursos de IO implementado na própria API nativa do Java.
    //Iremos utilizar o recurso de implementação para nesse classe implementar os métodos abstratos de listagem da 
    //serial e o método Run() da Thread.

 
public class SComm implements Runnable, SerialPortEventListener {

        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void serialEvent(SerialPortEvent spe) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

 

}


    
    
    //Agora vamos criar as seguintes variáveis que serão utilizadas durante o desenvolvimento:
    
    
    
    public String Dadoslidos;
    
    public int nodeBytes;
    
    private int baudrate;
    
    private int timeout;
    
    private CommPortIdentifier cp;
    
    private SerialPort porta;
    
    private OutputStream saida;
    
    private InputStream entrada;
    
    private Thread threadLeitura;
    
    private boolean IDPortaOK;
    
    private boolean PortaOK;
    
    private boolean Leitura;
    
    private boolean Escrita;
    
    private String Porta;
    
    protected String peso = "Porra! Ainda nao deu!";
    
    protected String dado;
    
    
    
    //Vamos definir os métodos para setar e resgatar os valores de peso para o processo de leitura da serial:
    
 
    
   public void setPeso(String peso){

        this.peso = peso;

}

 

public String getPeso(){

        return peso;

}





 //Vamos definir também o construtor da classe recebendo os parâmetros do seu hardware serial (é de suma importância que esses parâmetros estejam corretos, caso contrário a leitura/escrita serial não terá sucesso):

    public SerialComLeitura( String p , int b , int t )
        {
        this.Porta = p;

        this.baudrate = b;

        this.timeout = t;
        }        
    
    //Os dois métodos a seguir servem para habilitar hora a escrita hora a leitura serial, eles serão muito utilizados no decorrer desse artigo para habilitar um ou outro recurso já que a interface serial não suporta leitura e escrita de forma simultânea:
    
        
    public void HabilitarEscrita()
        {         
        Escrita = true;        
        Leitura = false;       
        }
    
    public void HabilitarLeitura()
        {            
        Escrita = false;
        Leitura = true;
        }
    
    //O método seguinte irá obter o ID da porta para ser utilizado na identificação da mesma:
 
    public void ObterIdDaPorta() ///////////////////////////////////////////original era void
        {
        try {
            cp = CommPortIdentifier.getPortIdentifier(Porta);
            if ( cp == null ) 
                {
                System.out.println("Erro na porta");
                IDPortaOK = false;
               // System.exit(1);//******************************************modificado do original
                }
            IDPortaOK = true;
            }
        catch (Exception e) 
            {
            System.out.println("Erro obtendo ID da porta: " + e);
            IDPortaOK = false;
           // System.exit(1);////******************************************modificado do original
            }
     //   return IDPortaOK;
        }
    
    
    
    //O método a seguir irá abrir a comunicação com a porta serial, após essa porta aberta podemos ou enviar ou ler a serial, é muito importante que os dados de DATABITS, STOPBITS, PARITY e FLOWCONTROL sejam exatos ao do seu equipamento serial, pois são parâmetros que vão estabelecer a velocidade e modo de leitura e escrita serial do computador com o seu equipamento:
    
    
    
    public void AbrirPorta()
        {        
        try 
            {
            porta = (SerialPort)cp.open("SerialComLeitura", timeout);
            PortaOK = true;
            //configurar parâmetros
            porta.setSerialPortParams(baudrate,
            porta.DATABITS_8,
            porta.STOPBITS_1,
            porta.PARITY_NONE);

            porta.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            }
        catch(Exception e)
            {
            PortaOK = false;
            System.out.println("Erro abrindo comunicação: " + e);
            System.exit(1);
            }
        }
    
    //O método abaixo irá habilitar a leitura da porta serial, vale lembrar que o “pulso” continuo de recebimento da serial será controlado pelo 
    //método abstrato serialEvent, o método então monitora a porta e obtém as entradas de dados pelo fluxo:
    
    public void LerDados(){

        if (Escrita == false){

            try {

                entrada = porta.getInputStream();

            } catch (Exception e) {

                System.out.println("Erro de stream: " + e);

                System.exit(1);

            }

            try {

                porta.addEventListener(this);

            } catch (Exception e) {

                System.out.println("Erro de listener: " + e);

                System.exit(1);

            }

            porta.notifyOnDataAvailable(true);

            try {

                threadLeitura = new Thread(this);

                threadLeitura.start();

               run();

            } catch (Exception e) {

                System.out.println("Erro de Thred: " + e);

            }

        }

}



 

//O método abaixo irá enviar uma string para a porta serial quando invocado:

 

public void EnviarUmaString(String msg){

        if (Escrita==true) {

            try {

                saida = porta.getOutputStream();

                //System.out.println("FLUXO OK!");

            } catch (Exception e) {

                System.out.println("Erro.STATUS: " + e );

            }

            try {

              //  System.out.println("Enviando um byte para " + Porta );

                //System.out.println("Enviando : " + msg );

                saida.write(msg.getBytes());

                Thread.sleep(100);

                saida.flush();

            } catch (Exception e) {

                System.out.println("Houve um erro durante o envio. ");

                System.out.println("STATUS: " + e );

                System.exit(1);

            }

        } else {

            System.exit(1);

        }

}





//Pronto, agora falta pouco, iremos agora construir um método abstrato run() esse método será o responsável por manter e controlar a execução da Thread de leitura da nossa aplicação serial:

 

    @Override
    public void run(){

        try {

            Thread.sleep(5);

        } catch (Exception e) {

            System.out.println("Erro de Thred: " + e);

        }

}

 

    //O método abstrato serialEvent() vai gerenciar todos os dados recebidos pela serial, note que o nosso maior 
    //interesse é no evento DATA_AVAILABLE que irá dizer se tem informação disponível para a leitura na serial, esse
    //trecho abaixo como toda a aplicação foi testada em inúmeras balanças de diversos fabricantes, dando uma margem 
    //de erro bem pequena, contudo se a sua aplicação ao ler dados enviados pela serial exibir dados quebrados, ou 
    //seja, se a string a ser recebida fosse “esse é um teste geral” recebesse da seguinte forma:
    
    //"esse é"
    
    //"um teste"
    
    //"    geral"
    
    
    
    //Isso significa que esse trecho precisa ser revisto, pois é ele que controla a informação e alguma incompatibilidade poderá ter ocorrido.
    
    
        
    @Override
    public void serialEvent(SerialPortEvent ev)
        {       
        StringBuffer bufferLeitura = new StringBuffer();
        int novoDado = 0;       
        switch (ev.getEventType()) 
            {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
            break;
            case SerialPortEvent.DATA_AVAILABLE:
                //Novo algoritmo de leitura.
                while(novoDado != -1)
                    {
                    try
                        {
                        novoDado = entrada.read();
                        if(novoDado == -1)
                            {
                            break;
                            }
                        if('\r' == (char)novoDado)
                            {
                            bufferLeitura.append('\n');
                            }
                        else
                            {
                            bufferLeitura.append((char)novoDado);
                            }

                        }
                    catch(IOException ioe)
                        {
                        System.out.println("Erro de leitura serial: " + ioe);
                        }
                    }
                setPeso(new String(bufferLeitura));
               // System.out.println(getPeso());
                break;
        }

}

 

//Agora somente os métodos para fechar a serial, obter a porta e obter o baurate do seu equipamento e assim essa classe está finalizada.

 

    public void FecharCom()
        {
        try 
            {
            porta.close();
            }
        catch (Exception e) 
            {
            System.out.println("Erro fechando porta: " + e);
            System.exit(0);
            }
        }
    
    
    
    public String obterPorta()
        {
        return Porta;
        }

   

    public int obterBaudrate()
        {
        return baudrate;
        }

}

 

