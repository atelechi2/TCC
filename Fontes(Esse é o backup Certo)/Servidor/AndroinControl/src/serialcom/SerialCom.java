/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serialcom;

import gnu.io.CommPortIdentifier;
import java.util.Enumeration;

/**
 *
 * @author Atelechi
 */
public class SerialCom 
    {
  
    //}
    
    
    //Chegamos à parte mais importante de todo o artigo, agora iremos escrever o código de leitura serial, o primeiro 
    //passo é criar os imports dentro da classe SerialCom, iremos codificar primeiro essa classe, para isso basta inserir
    //o seguinte código:
    
    //Agora vamos criar um array e uma variável do tipo Enumeration para trabalharmos nos métodos que serão criados:
    
    
    
    protected String[] portas;
    
    protected Enumeration listaDePortas;
    
    
    
    //O construtor da classe deverá ser da seguinte forma, já com a identificação das portas serias disponíveis:
    public SerialCom()
        {
        listaDePortas = CommPortIdentifier.getPortIdentifiers();
        }
    
    

    //Agora iremos montar o método para retornar as portas disponíveis:
    
    
    
    public String[] ObterPortas()
        {
        return portas;
        }
    
    //Até agora o processo foi bem simples, a seguir iremos construir dois métodos, o primeiro deles terá a função de armazenar uma lista das portas seriais do seu sistema disponíveis para a comunicação e o segundo irá identificar se a porta seleciona existe e está tudo em funcionamento com ela:
    public void ListarPortas()
        {
        int i = 0;
        portas = new String[10];
        while (listaDePortas.hasMoreElements()) 
            {
            CommPortIdentifier ips = (CommPortIdentifier)listaDePortas.nextElement();
            portas[i] = ips.getName();
            i++;
            }
        }
    
    
    
    public boolean PortaExiste(String COMp)
        {
        String temp;
        boolean e = false;
        while (listaDePortas.hasMoreElements()) 
            {
            CommPortIdentifier ips = (CommPortIdentifier)listaDePortas.nextElement();
            temp = ips.getName();
            if (temp.equals(COMp)== true) 
                {
                e = true;
                }
            }
        return e;
        }

    //Assim finalizamos a construção da classe SerialCom, vamos agora iniciar o desenvolvimento da classe SerialComLeitura onde vamos implementar a interface que vai ficar “ouvindo” a porta para a captura de dados ou ainda via mandar dados para a porta serial.
}