/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;
import java.util.List;
import BD.BEAN.LogsBean;

/**
 *
 * @author Atelechi
 */
public interface LogsDAO 
  {
  public void insereAcao(LogsBean usuario) throws Exception;
  public void removeAcao(LogsBean usuario, int id) throws Exception;
  public List<LogsBean> listaAcoes()throws Exception;//LogsBean usuario)throws Exception;
     
  }
