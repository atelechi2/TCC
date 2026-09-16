/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.BEAN;

/**
 *
 * @author Angelo
 */
public class UsuarioBean
    {
    private int id;
    private String login;
    private String senha;
    private String nome;
    
    public UsuarioBean()
        {
        
        }

//ID
    public int getId() 
        {
        return id;
        }
    public void setIdUsuario(int idUsuario) 
        {
        this.id = idUsuario;
        }

//LOGIN   
    public String getLogin() 
        {
        return login;
        }
    public void setLogin(String login) 
        {
        this.login = login;
        }

//SENHA    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//NOME    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

}
