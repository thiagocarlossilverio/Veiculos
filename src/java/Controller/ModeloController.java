package Controller;

import Bean.MarcaBean;
import Bean.ModeloBean;
import Dao.ModeloDao;
import Dao.UsuarioDao;
import Util.UtilInterface;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author TCS
 */
@ManagedBean
@SessionScoped
public class ModeloController {
    
    
 private ModeloBean mrl = new ModeloBean();
  private List<ModeloBean> lista;
  private DataModel listamodelo;
    private int idModelo;
    private boolean s = true;
    
    
    
    
    private int idMarca;

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    
    
    
    
     public DataModel getListarmodelo() {
        listamodelo = new ListDataModel(getLista());
        return listamodelo;
    }
    public void setLista(List<ModeloBean> lista) {
        this.lista = lista;
    }
    
     public DataModel getModel() {
        List<ModeloBean> lista = null;
        try {
            lista = ModeloDao.getLista();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listamodelo = new ListDataModel(lista);
        return listamodelo;
    }
     
    public List<ModeloBean> getLista() {
        try {
            return Dao.ModeloDao.getLista();
            
        }catch(SQLException ex) {
        
            ex.printStackTrace();
            return null;
        }

    }
     
     
    
     
     public ModeloBean getMrl() {
        return mrl;
    }

    public void setMrl(ModeloBean mrl) {
        this.mrl = mrl;
    }

    

    public void novo() {
        mrl = new ModeloBean();
        s = true;
    }

    public void recuperaObjetoSelecionado(){
        mrl = (ModeloBean) (listamodelo.getRowData());
    }
    
    public void Alterar() {
        recuperaObjetoSelecionado();
        s = false;
    }

    public void preparaExcluir() {
        recuperaObjetoSelecionado();
    }

    public void excluir() {
        try {
            ModeloDao.excluir(mrl);
            UtilInterface.msgSucesso("Excluido com Sucesso!");
        }catch(com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException e){
            UtilInterface.msgSucesso("Impossível excluir registro!");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public void gravar() {
        try {
            mrl.setIdmarca(idMarca);
            new ModeloDao().salvar(mrl);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incluido com Sucesso"));
        } catch (Exception a) {
            a.printStackTrace();
        }

    }
}


