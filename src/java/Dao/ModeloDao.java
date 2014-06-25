/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Bean.ModeloBean;
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
public class ModeloDao {
    
 public static void salvar(ModeloBean m) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "insert into modelo (descricao, idmarca) values (?,?)";
    
         PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, m.getDescricao());
         stmt.setInt(2, m.getIdmarca());
         stmt.execute();
        con.close();
}
     
 
  public static void alterar(ModeloBean m) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "UPDATE modelo SET idmodelo=?, descricao=? where idmodelo=?";

        PreparedStatement stmt = con.prepareStatement(sql);
       stmt.setString(1, m.getDescricao());
         stmt.setInt(2, m.getIdmarca());
        stmt.executeUpdate();
        con.close();
    }

    public static void excluir(ModeloBean use) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "delete from modelo where idmodelo=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, use.getDescricao());
         stmt.setInt(2, use.getIdmarca());
         stmt.executeUpdate();
        con.close();
    }
 
 
 
 
      public static List<ModeloBean> getLista() throws SQLException{
        List<ModeloBean> lista = new ArrayList<ModeloBean>();
        Connection con = Conexao.getConnection();
        String sql = "select * from modelo order by descricao";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            ModeloBean m = new ModeloBean();
           
            m.setIdmodelo(rs.getInt("idmodelo"));
            m.setDescricao(rs.getString("descricao"));
            m.setIdmarca(rs.getInt("idmarca"));
            lista.add(m);
        }
        stmt.close();       
        rs.close();
        con.close();
        return lista;
    }


public static ModeloBean getmodelo(int id)throws SQLException{
        ModeloBean use = new ModeloBean();
        Connection con = Conexao.getConnection();
        String sql ="select * from modelo where idmodelo="+id;
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
       
            ModeloBean m = new ModeloBean();
             m.setIdmodelo(rs.getInt("idmodelo"));
            m.setDescricao(rs.getString("descricao"));
            m.setIdmarca(rs.getInt("idmarca"));
           
            stmt.close();
            rs.close();
            con.close();
            return m;
            
    }
}

