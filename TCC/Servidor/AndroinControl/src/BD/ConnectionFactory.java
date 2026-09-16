/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Atelechi
 */
public class ConnectionFactory {

   // private Connection con;

    public ConnectionFactory() {
    }

    public Connection getConnection() throws Exception {

        try {
           // Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost//data//navios","root","");
            return DriverManager.getConnection("jdbc:mysql://localhost/android_control", "root", "");
        } catch (SQLException ex) {
            throw new Exception("Erro ao Criar a conexao:" + ex.getMessage());

            //log do server// Logger.getLogger(ConnectionFactory.class.getName()).log(level.SEVERE, null, ex);
        }
       
    }

    public void closeConnection(Connection con) throws Exception {
        try {
            con.close();
        } catch (SQLException ex) {
            throw new Exception("Erro ao Criar a conexao:" + ex.getMessage());
            //log do server// Logger.getLogger(ConnectionFactory.class.getName()).log(level.SEVERE, null, ex);
        }

    }
}
