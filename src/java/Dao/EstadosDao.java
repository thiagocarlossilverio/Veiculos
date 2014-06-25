/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.EstadosBean;
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
public class EstadosDao {
    
    
     public static List<EstadosBean> getLista() throws SQLException{
        List<EstadosBean> lista = new ArrayList<EstadosBean>();
        Connection con = Conexao.getConnection();
        String sql = "select * from estados order by uf";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            EstadosBean e = new EstadosBean();
            e.setIdestados(rs.getInt("idestados"));
            e.setEstado(rs.getString("estado"));
            e.setUf(rs.getString("uf"));
            lista.add(e);
        }
        stmt.close();        rs.close();        con.close();
        return lista;
    }
}
