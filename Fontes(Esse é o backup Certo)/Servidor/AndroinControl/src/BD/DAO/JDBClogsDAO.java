/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import BD.BEAN.LogsBean;
import BD.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atelechi
 */
public class JDBClogsDAO implements LogsDAO
    {
    ConnectionFactory fabrica;
    Connection con;

//******************************************** CONSTRUTOR *******************************************
    public JDBClogsDAO() throws Exception 
        {
        fabrica = new ConnectionFactory();
        con = fabrica.getConnection();
        }
    
  
//******************************************** Insere acoes *******************************************
    @Override
    public void insereAcao(LogsBean user) throws Exception 
        {
        PreparedStatement ps;
        int  id          = user.getId();
        int  id_usuario  = user.getId_Usuario();
        Date datas        = user.getData();
        int  listaacao_id        = user.getListaacao_id();
        
        String sql = "INSERT INTO log"
                + "(id_usuario,listaacao_id)"//"(id_usuario,data,acao)"
                + "VALUES(?,?)";//CURRENT_TIMESTAMP new Date()
        ps = (PreparedStatement) con.prepareStatement(sql);
        ps.setInt(1, id_usuario);
//************************************************************************************ 
     //Sempre pega data atual pelo banco (on update CURRENT_TIMESTAMP)
//******************************************************************************************
        
        //ps.setDate(2, new java.sql.Date(data.getTime()));
        ps.setInt(2, listaacao_id);
        ps.executeUpdate();
        con.close();
        }

//******************************************** LISTA ACOES *******************************************
    @Override
     public List<LogsBean> listaAcoes()//LogsBean usuario)
        {
        PreparedStatement ps;
        ResultSet rs;
        List<LogsBean> log = new ArrayList<LogsBean>();
        String SQL = "select * from log order by id";
        try 
            {
            ps = (PreparedStatement) con.prepareStatement(SQL);
            rs = ps.executeQuery();
         
            
            while(rs.next())
                {
                LogsBean acao = new LogsBean();    
                acao.setId(rs.getInt("id"));
                acao.setId_Usuario(rs.getInt("id_usuario"));
                acao.setData(rs.getDate("data"));
                acao.setDataHora(rs.getTime("data"));
                acao.setListaacao_id(rs.getInt("listaacao_id"));       
                log.add(acao);
                }
            }
        catch (SQLException ex) 
            {
            Logger.getLogger(JDBCusuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return log;
    }

    
//******************************************** Remove ACOES *******************************************  
 @Override
      public void removeAcao(LogsBean usuario, int id) throws Exception 
        {
        PreparedStatement ps;
        String sql = "DELETE FROM usuario "
                   + "WHERE id_usuario = " + id;
        ps = (PreparedStatement) con.prepareStatement(sql);
        ps.executeUpdate();
        con.close();
        }

    }
  