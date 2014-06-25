package Controller;

import Dao.UsuarioDao;
import Bean.UsuarioBean;
import Util.UtilInterface;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
public class UsuarioController {

    private UsuarioBean user = new UsuarioBean();
    private List<UsuarioBean> lista;
    private DataModel listaUsuarios;
    private boolean u = true;

    public DataModel getListarUsuarios() {
        listaUsuarios = new ListDataModel(getLista());
        return listaUsuarios;
    }

    public void setLista(List<UsuarioBean> lista) {
        this.lista = lista;
    }

    public DataModel getModel() {
        List<UsuarioBean> lista = null;
        try {
            lista = UsuarioDao.getLista();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listaUsuarios = new ListDataModel(lista);
        return listaUsuarios;
    }

    public List<UsuarioBean> getLista() {
        try {
            return UsuarioDao.getLista();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public UsuarioBean getUser() {
        return user;
    }

    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    public void novo() {
        user = new UsuarioBean();
        u = true;
    }

    public void recuperaObjetoSelecionado() {
        user = (UsuarioBean) (listaUsuarios.getRowData());
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
            UsuarioDao.excluir(user);
            UtilInterface.msgSucesso("Excluido com Sucesso!");
        } catch (com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException e) {
            UtilInterface.msgSucesso("Impossível excluir registro!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void gravar(ActionEvent e) {
        try {
            new UsuarioDao().salvar(user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incluido com Sucesso"));
        } catch (Exception a) {
            a.printStackTrace();
        }

    }

    public String logar() {
        String sei = "falha";
        sei = new UsuarioDao().logar(user.getUsuario(), user.getSenha());
        return sei;
    }
}