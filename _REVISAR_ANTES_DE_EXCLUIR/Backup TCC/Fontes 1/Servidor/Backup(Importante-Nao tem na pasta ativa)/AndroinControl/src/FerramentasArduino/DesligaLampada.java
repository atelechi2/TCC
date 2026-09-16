/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FerramentasArduino;

import serialcom.SerialComLeitura;
import serialcom.SerialCom;


//import net.viamais.serial.SerialCom;

//import net.viamais.serial.SerialComLeitura;
/**
 *
 * @author Atelechi
 */
public class DesligaLampada 
    {
    



 

//Nada muito complicado, agora precisamos extender a classe SerialCom para dar continuidade ao nosso trabalho:

 

    public class Main extends SerialCom 
        {
        }
//Agora vamos gerar o construtor com o array de erros conforme a padronização do Java:
    
        public static void main(String[] args)
            {
//Agora que já preparamos a parte inicial da nossa classe Main (principal) vamos nos ater ao código de escrita propriamente dito, o próximo passo é criar uma instancia da classe SerialComLeitura na nossa classe Main tomando o cuidado de informar os parâmetros de endereço da porta, no caso COM1, o baudrate, no caso 9600 e o timeout, no caso 0:
            SerialComLeitura serialEscrita = new SerialComLeitura("COM9", 9600, 0);
//Pronto agora já temos a instancia serialEscrita pronta para aproveitarmos os seus métodos e iniciar o nosso processo, no próximo passo vamos ir aproveitando os métodos de identificação, verificação de disponibilidade, abertura, envio e finalmente fechamento da porta serial para fecharmos todo o ciclo do processo de escrita na porta serial (é preciso atenção, pois a chamada de um método fora de ordem como está abaixo vai comprometer todo o funcionamento do nosso exemplo):
            serialEscrita.HabilitarEscrita();

            serialEscrita.ObterIdDaPorta();

            serialEscrita.AbrirPorta();

            serialEscrita.EnviarUmaString("D");

            serialEscrita.FecharCom();
            }
        }
    
