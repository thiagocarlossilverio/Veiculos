/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.CidadesBean;
import Bean.ModeloBean;
import Bean.UsuarioBean;
import Bean.VeiculoBean;
import Dao.UsuarioDao;
import Dao.VeiculoDao;
import Util.UtilInterface;
import com.sun.faces.renderkit.ApplicationObjectInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import java.io.ByteArrayInputStream;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author TCS
 */
@ManagedBean
@SessionScoped
public class VeiculoController {

    private VeiculoBean veic = new VeiculoBean();
    private List<VeiculoBean> lista;
    private DataModel listaVeiculos;
    private VeiculoBean veiculoselecionado = new VeiculoBean();
    private boolean u = true;
    private int idCidades;
    private int id;
    private StreamedContent imagem;
    private byte[] foto;
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public VeiculoBean getveiculoselecionado() {
        return veiculoselecionado;
    }

    public void setveiculoselecionado(VeiculoBean veiculoselecionado) {
        this.veiculoselecionado = veiculoselecionado;
    }

    public int getIdCidades() {
        return idCidades;
    }

    public void setIdCidades(int idcidades) {
        this.idCidades = idcidades;
    }

    public DataModel getListarVeiculos() {
        listaVeiculos = new ListDataModel(getLista());
        return listaVeiculos;
    }

    public DataModel getListarCarro() {
        listaVeiculos = new ListDataModel(getLista("Carro"));
        return listaVeiculos;
    }

    public DataModel getListarMoto() {
        listaVeiculos = new ListDataModel(getLista("Moto"));
        return listaVeiculos;
    }

    public DataModel getListarCaminhao() {
        listaVeiculos = new ListDataModel(getLista("Caminhao"));
        return listaVeiculos;
    }

    public StreamedContent getImagem() {
        return imagem;
    }

    
    public void setImagem(StreamedContent imagem) {
        this.imagem = imagem;
    }

    public void limpaImagem() {
        this.imagem = new DefaultStreamedContent();
    }

    public void setLista(List<VeiculoBean> lista) {
        this.lista = lista;
    }

    public DataModel getModel() {
        List<VeiculoBean> lista = null;
        try {
            lista = VeiculoDao.getLista();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listaVeiculos = new ListDataModel(lista);
        return listaVeiculos;
    }

    public List<VeiculoBean> getLista() {
        try {
            return VeiculoDao.getLista();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<VeiculoBean> getLista(String filtro) {
        try {
            return VeiculoDao.getLista(filtro);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {
            imagem = new DefaultStreamedContent(event.getFile().getInputstream());
            byte[] fotocapa = event.getFile().getContents();
            this.veic.setFotocapa(fotocapa);
        } catch (IOException ex) {
            Logger.getLogger(VeiculoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public VeiculoBean getVeic() {
        return veic;
    }

    public void setVeic(VeiculoBean veic) {
        this.veic = veic;
    }

    public void mudaVeiculo() {
        veic.setIdveiculo(veiculoselecionado.getIdveiculo());
        veic.setAno(veiculoselecionado.getAno());
        veic.setDescricao(veiculoselecionado.getDescricao());
        veic.setFotocapa(veiculoselecionado.getFotocapa());
        imagem = new DefaultStreamedContent(new ByteArrayInputStream(veic.getFotocapa()));
    }

    public void buscaJogador() {
    }

    public void novo() {
        veic = new VeiculoBean();
        u = true;
    }

    public void recuperaObjetoSelecionado() {
        veic = (VeiculoBean) (listaVeiculos.getRowData());
    }

    public void Alterar() {
        recuperaObjetoSelecionado();
        u = false;
    }

    public void preparaExcluir() {
        recuperaObjetoSelecionado();
    }

    public void excluir() {
        try {
            VeiculoDao.excluir(veic);
            UtilInterface.msgSucesso("Excluido com Sucesso!");
        } catch (com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException e) {
            UtilInterface.msgSucesso("Impossível excluir registro!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void gravar() {
        try {
            veic.setIdcidades(idCidades);
            veic.setIdmodelo(id);


            new VeiculoDao().salvar(veic);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incluido com Sucesso"));
        } catch (Exception a) {
            a.printStackTrace();
        }
    }

    public StreamedContent getFoto(byte[] foto) {
        imagem = new DefaultStreamedContent(new ByteArrayInputStream(foto));
        System.out.println("imprimiu: " + imagem);
        return imagem;
    }
}
