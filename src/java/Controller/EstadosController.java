/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.EstadosBean;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author TCS
 */
@ManagedBean
public class EstadosController {
    

private EstadosBean est = new EstadosBean();
    private List<EstadosBean> lista;

    public EstadosBean getEst() {
        return est;
    }

    public void setEst(EstadosBean est) {
        this.est = est;
    }

   
    public List<EstadosBean> getLista() {
        try {
            return Dao.EstadosDao.getLista();
            
        }catch(SQLException ex) {
        
            ex.printStackTrace();
            return null;
        }

    }


}
