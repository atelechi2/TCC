/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.BEAN;


import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author Atelechi
 */
public class LogsBean 
    {
    private int id;
    private int id_usuario;
    private Date data;
    private Date hora;
    private int acao;
     
    public LogsBean() 
        {
        }

//ID
    public int getId() 
        {
        return id;
        }
    public void setId(int id) 
        {
        this.id = id;
        }


//Chave extrangeira ID Usuario    
    public int getId_Usuario()
        {
        return id_usuario;
        }
    public void setId_Usuario(int id_Usuario)
        {
        this.id_usuario = id_Usuario;
        }

//DATA
    public Date getData()
        {
        return data;
        }    
  public void setData(Date data)
       {
       this.data = data;
        }
  
  //HORA
    public Date getDataHora()
        {
        return hora;
        }    
  public void setDataHora(Date hora)
       {
       this.hora = hora;
        }
  
//ACAO
    public int getAcao()
        {
        return acao;
        }
    public void setAcao(int acao)
        {
        this.acao = acao;
        }

  
    }
