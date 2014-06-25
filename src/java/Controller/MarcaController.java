/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author TCS
 */
import Bean.MarcaBean;
import Dao.MarcaDao;
import Util.UtilInterface;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
public class MarcaController {

    private MarcaBean mrc = new MarcaBean();
    private List<MarcaBean> lista;
    private DataModel listamarcas;
    private boolean u = true;
    private int idmarca;
    //codiigo novo
    private List<MarcaBean> listaMarca = new ArrayList<MarcaBean>();

    public List<MarcaBean> getListaMarca() {
        try {
            return MarcaDao.getLista();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setListaMarca(List<MarcaBean> listaMarca) {
        this.listaMarca = listaMarca;
    }

    public DataModel getListarMarcas() {
        try {
            listamarcas = new ListDataModel(MarcaDao.getLista());
            return listamarcas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setLista(List<MarcaBean> lista) {
        this.lista = lista;
    }

    public DataModel getModel() {
        List<MarcaBean> lista = null;
        try {
            lista = MarcaDao.getLista();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listamarcas = new ListDataModel(lista);
        return listamarcas;
    }

    public List<MarcaBean> getLista() {
        try {
            return MarcaDao.getLista();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public MarcaBean getMrc() {
        return mrc;
    }

    public void setMrc(MarcaBean mrc) {
        this.mrc = mrc;
    }

    public void novo() {
        mrc = new MarcaBean();
        u = true;
    }

    public void recuperaObjetoSelecionado() {
        mrc = (MarcaBean) (listamarcas.getRowData());
    }

    public void aAlterar() {
        recuperaObjetoSelecionado();
        u = false;
    }

    public void preparaExcluir() {
        recuperaObjetoSelecionado();
    }

    public void excluir() {
        try {
            MarcaDao.excluir(mrc);
            UtilInterface.msgSucesso("Excluido com Sucesso!");
        } catch (com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException e) {
            UtilInterface.msgSucesso("Impossível excluir registro!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void gravar(ActionEvent e) {
        try {
            new MarcaDao().salvar(mrc);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incluido com Sucesso"));
        } catch (Exception a) {
            a.printStackTrace();
        }

    }
}
