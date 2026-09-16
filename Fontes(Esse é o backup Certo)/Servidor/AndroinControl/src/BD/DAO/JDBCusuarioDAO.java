package BD.DAO;

import BD.BEAN.UsuarioBean;
import br.com.aula.util.MD5;

import BD.ConnectionFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Atelechi
 */
public class JDBCusuarioDAO implements UsuarioDAO 
    {
    ConnectionFactory fabrica;
    Connection con;

//Construtor
    public JDBCusuarioDAO() throws Exception 
        {
        try 
            {
            fabrica = new ConnectionFactory();
            con = fabrica.getConnection();
            }
        catch (Exception ex) 
            {
            throw new Exception("CONSTRUTOR jdbcusuariodao: " + ex.getMessage());
            }
        }

//******************************************** Insere Usuario *******************************************
    @Override
    public void insereUsuario(UsuarioBean user) throws Exception 
        {
        PreparedStatement ps;
        int id = user.getId();
        String login = user.getLogin();
        String senha = MD5.setMD5(user.getSenha());//Criptografa a senha com MD5
        String nome  = user.getNome();
        
        
        String sql = "INSERT INTO usuario"
                + "(login,senha,nome)"
                + "VALUES(?,?,?)";

        ps = (PreparedStatement) con.prepareStatement(sql);

        ps.setString(1, login);
        ps.setString(2, senha);
        ps.setString(3, nome);
       
        ps.executeUpdate();

        con.close();
        }

    
//---------------------------------------Remove Usuario------------------------------------    
    @Override
    public void removeUsuario(UsuarioBean usuario, int idUsuario) throws Exception 
        {
        PreparedStatement ps;
      
        String sql = "DELETE FROM usuario "
                   + "WHERE idUsuario = " + idUsuario;

        ps = (PreparedStatement) con.prepareStatement(sql);
        
        
        ps.executeUpdate();

        con.close();
        }

//********************************************** Lista Usuario **********************************************
    @Override
    public List<UsuarioBean> listaUsuarios() 
        {
        PreparedStatement ps;
        ResultSet rs;
        List<UsuarioBean> matrizUsuario = new ArrayList<UsuarioBean>();
       
        String SQL = "select * from usuario";
        try 
            {
            ps = (PreparedStatement) con.prepareStatement(SQL);
            rs = ps.executeQuery();
            UsuarioBean usuario;
            
            while(rs.next())
                {
                usuario = new UsuarioBean();
                
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNome(rs.getString("nome"));                
                
                matrizUsuario.add(usuario);
                }
            }
        catch (SQLException ex) 
            {
            Logger.getLogger(JDBCusuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return matrizUsuario;
        }

//*************************************** ALTERAREGISTRO ************************************************
    @Override
    public void alteraRegistro(UsuarioBean usuario, int idUsuario) throws Exception 
        {
        PreparedStatement ps;
      
        int id = usuario.getId();
        System.out.print("ID: "+id);        
        
        String login = usuario.getLogin();
        System.out.print("Login: "+login);
        
        String senha = usuario.getSenha();
        System.out.print("Senha: "+senha);
        
        String nome = usuario.getNome();
        System.out.print("Nome: "+nome);
        
        
        String sql = "UPDATE usuario "
                    + "SET nome ='"   +login+       "',"
                    + "   email ='"   +senha+       "',"
                    + " endereco='"   +nome+        "',"
                    + "WHERE idUsuario = " + id;

        ps = (PreparedStatement) con.prepareStatement(sql);
        
        
        ps.executeUpdate();

        con.close();

        }
    
    
    
    
//******************************************* REGISTRO USUARIO **********************************************
    @Override
    public UsuarioBean registrosUsuario(int idUsuario) 
        {
        PreparedStatement ps = null;
        ResultSet rs = null;
         
        String SQL = "select * from usuario where idUsuario = " + idUsuario;
        
        try 
            {
            ps = (PreparedStatement) con.prepareStatement(SQL);
            }
        catch (SQLException ex) 
            {
            Logger.getLogger(JDBCusuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        try 
            {
            rs = ps.executeQuery();
            }
        catch (SQLException ex) 
            {
            Logger.getLogger(JDBCusuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        UsuarioBean usuario = null;
        try {
            if(rs.next() == true)
                {
                usuario = new UsuarioBean();
                
                usuario.setIdUsuario(rs.getInt("id"));             
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
               
                }
            } 
            catch (SQLException ex) 
                {
                Logger.getLogger(JDBCusuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
         
        return usuario;
        }


  
}

       