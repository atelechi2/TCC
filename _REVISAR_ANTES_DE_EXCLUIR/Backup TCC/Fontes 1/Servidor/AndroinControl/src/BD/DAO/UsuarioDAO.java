package BD.DAO;


import BD.BEAN.UsuarioBean;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Atelechi
 */
public interface UsuarioDAO 
    {
    
    public void insereUsuario(UsuarioBean usuario) throws Exception;
    public void removeUsuario(UsuarioBean usuario,int idUsuario) throws Exception;
    public void alteraRegistro(UsuarioBean usuario,int idUsuario) throws Exception;
    public UsuarioBean registrosUsuario(int idUsuario);
    public List<UsuarioBean> listaUsuarios();
    }
