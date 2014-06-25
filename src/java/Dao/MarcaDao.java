/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.MarcaBean;
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
public class MarcaDao {
    
     public static void salvar(MarcaBean m) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "insert into marca (descricao) values "
                + "(?)";
    
         PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, m.getDescricao());
         stmt.execute();
        con.close();
}
     
     
     
     public static void alterar(MarcaBean m) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "UPDATE marca SET descricao=? WHERE idmarca =?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, m.getDescricao());

        stmt.executeUpdate();
        con.close();
    }

    public static void excluir(MarcaBean mrc) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "delete from marca where idmarca=?";
       PreparedStatement stmt = con.prepareStatement(sql);
       
       stmt.setString(1, mrc.getDescricao());
         stmt.executeUpdate();
        con.close();
    }

     
    
     
     
      public static List<MarcaBean> getLista() throws SQLException{
        List<MarcaBean> lista = new ArrayList<MarcaBean>();
        Connection con = Conexao.getConnection();
        String sql = "select * from marca order by descricao";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            MarcaBean m = new MarcaBean();
            m.setIdmarca(rs.getInt("idmarca"));
            m.setDescricao(rs.getString("descricao"));
            lista.add(m);
        }
        stmt.close(); 
        rs.close();    
        con.close();
        return lista;
    }
      
      
public static MarcaBean getMarca(int id)throws SQLException{
        MarcaBean mrc = new MarcaBean();
        Connection con = Conexao.getConnection();
        String sql ="select * from marca where idmarca ="+id;
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
       
           MarcaBean m = new MarcaBean();
            m.setIdmarca(rs.getInt("idmarca"));
            m.setDescricao(rs.getString("descricao"));
                     
            stmt.close();
            rs.close();
            con.close();
            return m;
            
    }
}
