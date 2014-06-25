/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Bean.CidadesBean;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author TCS
 */
@ManagedBean
public class CidadesController {
   
    private CidadesBean cid = new CidadesBean();
    private List<CidadesBean> lista;

    public CidadesBean getCid() {
        return cid;
    }

    public void setCid(CidadesBean cid) {
        this.cid = cid;
    }

   
    public List<CidadesBean> getLista() {
        try {
            return Dao.CidadesDao.getLista();
            
        }catch(SQLException ex) {
        
            ex.printStackTrace();
            return null;
        }

    }



}
