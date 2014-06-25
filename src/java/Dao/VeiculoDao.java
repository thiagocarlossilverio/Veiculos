/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.ModeloBean;
import Bean.VeiculoBean;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author TCS
 */
public class VeiculoDao {

   
    public static void salvar(VeiculoBean v) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "insert into veiculo (ano, cor, descricao, valor, fotocapa, foto1, foto2, foto3, foto4, idcidades, idusuario, idmodelo, tipo) values "
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";


        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, v.getAno());
        stmt.setString(2, v.getCor());
        stmt.setString(3, v.getDescricao());
        stmt.setString(4, v.getValor());
        stmt.setBytes(5, v.getFotocapa());
        stmt.setBytes(6, v.getFoto1());
        stmt.setBytes(7, v.getFoto2());
        stmt.setBytes(8, v.getFoto3());
        stmt.setBytes(9, v.getFoto4());
        stmt.setInt(10, v.getIdcidades());
        stmt.setInt(11, v.getIdusuario());
        stmt.setInt(12, v.getIdmodelo());
        stmt.setString(13, v.getTipo());

        System.out.println(sql);
        stmt.execute();
        con.close();
    }

    public static void alterar(VeiculoBean v) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "UPDATE veiculo SET ano=?, cor=?, descricao=?, valor=?,fotocapa=?, foto1=?,foto2=?, foto3=?, foto4=?, idcidades=?, idusuario=?, idmodelo=?, tipo=? WHERE idveiculo =?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, v.getAno());
        stmt.setString(2, v.getCor());
        stmt.setString(3, v.getDescricao());
        stmt.setString(4, v.getValor());
        stmt.setBytes(5, v.getFotocapa());
        stmt.setBytes(6, v.getFoto1());
        stmt.setBytes(7, v.getFoto2());
        stmt.setBytes(8, v.getFoto3());
        stmt.setBytes(9, v.getFoto4());
        stmt.setInt(10, v.getIdcidades());
        stmt.setInt(11, v.getIdusuario());
        stmt.setInt(12, v.getIdmodelo());
        stmt.setString(13, v.getTipo());

        stmt.executeUpdate();
        con.close();
    }

    public static void excluir(VeiculoBean veic) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "delete from veiculo where idveiculo=?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, veic.getAno());
        stmt.setString(2, veic.getCor());
        stmt.setString(3, veic.getDescricao());
        stmt.setString(4, veic.getValor());
        stmt.setBytes(5, veic.getFotocapa());
        stmt.setBytes(6, veic.getFoto1());
        stmt.setBytes(7, veic.getFoto2());
        stmt.setBytes(8, veic.getFoto3());
        stmt.setBytes(9, veic.getFoto4());
        stmt.setInt(10, veic.getIdcidades());
        stmt.setInt(11, veic.getIdusuario());
        stmt.setInt(12, veic.getIdmodelo());
        stmt.setString(13, veic.getTipo());
        stmt.executeUpdate();
        con.close();
    }

    public static List<VeiculoBean> getLista(String filtro) throws SQLException {
        List<VeiculoBean> lista = new ArrayList<VeiculoBean>();
        Connection con = Conexao.getConnection();
        String sql = "select veiculo.*, modelo.idmodelo, modelo.descricao as descricaoModelo from veiculo, modelo  where veiculo.idmodelo = modelo.idmodelo  and veiculo.tipo = '"+filtro+"' order by idveiculo";
        System.out.println(sql);
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            VeiculoBean v = new VeiculoBean();
            ModeloBean modelo = new ModeloBean();
            modelo.setDescricao(rs.getString("descricaoModelo"));
            modelo.setIdmodelo(rs.getInt("idmodelo"));
            v.setIdveiculo(rs.getInt("idveiculo"));
            v.setAno(rs.getString("ano"));
            v.setCor(rs.getString("cor"));
            v.setDescricao(rs.getString("descricao"));
            v.setValor(rs.getString("valor"));
            v.setFotocapa(rs.getBytes("fotocapa"));
            v.setFoto1(rs.getBytes("foto1"));
            v.setFoto2(rs.getBytes("foto2"));
            v.setFoto3(rs.getBytes("foto3"));
            v.setFoto4(rs.getBytes("foto4"));
            v.setIdcidades(rs.getInt("idcidades"));
            v.setIdusuario(rs.getInt("idusuario"));
            v.setIdmodelo(rs.getInt("idmodelo"));
            v.setTipo(rs.getString("tipo"));
            v.setModelo(modelo);
            

            lista.add(v);
        }
        stmt.close();
        rs.close();
        con.close();
        return lista;
    }

    
    public static List<VeiculoBean> getLista() throws SQLException {
        List<VeiculoBean> lista = new ArrayList<VeiculoBean>();
        Connection con = Conexao.getConnection();
        String sql = "select * from veiculo order by idveiculo";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            VeiculoBean v = new VeiculoBean();
            v.setIdveiculo(rs.getInt("idveiculo"));
            v.setAno(rs.getString("ano"));
            v.setCor(rs.getString("cor"));
            v.setDescricao(rs.getString("descricao"));
            v.setValor(rs.getString("valor"));
            v.setFotocapa(rs.getBytes("fotocapa"));
            v.setFoto1(rs.getBytes("foto1"));
            v.setFoto2(rs.getBytes("foto2"));
            v.setFoto3(rs.getBytes("foto3"));
            v.setFoto4(rs.getBytes("foto4"));
            v.setIdcidades(rs.getInt("idcidades"));
            v.setIdusuario(rs.getInt("idusuario"));
            v.setIdmodelo(rs.getInt("idmodelo"));
            v.setTipo(rs.getString("tipo"));
            

            lista.add(v);
        }
        stmt.close();
        rs.close();
        con.close();
        return lista;
    }
    
    public static VeiculoBean getVeiculo(int id) throws SQLException {
        VeiculoBean veic = new VeiculoBean();
        Connection con = Conexao.getConnection();
        String sql = "select * from veiculo where idveiculo =" + id;
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        VeiculoBean v = new VeiculoBean();

        v.setIdveiculo(rs.getInt("idveiculo"));
        v.setAno(rs.getString("ano"));
        v.setCor(rs.getString("cor"));
        v.setDescricao(rs.getString("descricao"));
        v.setValor(rs.getString("valor"));
        v.setFotocapa(rs.getBytes("fotocapa"));
        v.setFoto1(rs.getBytes("foto1"));
        v.setFoto2(rs.getBytes("foto2"));
        v.setFoto3(rs.getBytes("foto3"));
        v.setFoto4(rs.getBytes("foto4"));
        v.setIdcidades(rs.getInt("idcidade"));
        v.setIdusuario(rs.getInt("idusuario"));
        v.setIdmodelo(rs.getInt("idmodelo"));
        v.setTipo(rs.getString("tipo"));
        stmt.close();
        rs.close();
        con.close();
        return v;

    }
}
