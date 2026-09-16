/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import BD.BEAN.ListaAcaoBean;
import BD.BEAN.LogsBean;
import BD.DAO.ListaAcaoDAO;
import BD.DAO.JDBClistaAcaoDAO;
import BD.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atelechi
 */
public class JDBClistaAcaoDAO implements ListaAcaoDAO
    {
    ConnectionFactory fabrica;
    Connection con;

    public JDBClistaAcaoDAO() throws Exception 
        {
            fabrica = new ConnectionFactory();
            con = fabrica.getConnection();
        }
    
    

  
//******************************************** Lista Acao *******************************************
    @Override
     public List<ListaAcaoBean> listaAcoes()//LogsBean usuario)
        {
        PreparedStatement ps;
        ResultSet rs;
        List<ListaAcaoBean> log = new ArrayList<ListaAcaoBean>();
       
        String SQL = "select * from listaacao order by id";
        try 
            {
            ps = (PreparedStatement) con.prepareStatement(SQL);
            rs = ps.executeQuery();
         
            
            while(rs.next())
                {
                ListaAcaoBean acao = new ListaAcaoBean();
                
                acao.setIdUsuario(rs.getInt("id"));
                acao.setAcao(rs.getString("acao"));
                        
                log.add(acao);
                }
            }
        catch (SQLException ex) 
            {
            Logger.getLogger(JDBCusuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return log;

        }
    

    }
