/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.BEAN;

/**
 *
 * @author Atelechi
 */
public class ListaAcaoBean 
    {
    private int id;
    private String acao;
     
    public ListaAcaoBean() 
        {
        }

//ID
    public int getId() 
        {
        return id;
        }
    public void setIdUsuario(int id) 
        {
        this.id = id;
        }

//Chave extrangeira ID Usuario    
    public String getAcao()
        {
        return acao;
        }
    public void setAcao(String acao)
        {
        this.acao = acao;
        }

    }
