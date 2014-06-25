/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.CidadesBean;
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
public class CidadesDao {
    
public static List<CidadesBean> getLista() throws SQLException{
        List<CidadesBean> lista = new ArrayList<CidadesBean>();
        Connection con = Conexao.getConnection();
        String sql = "select * from cidades order by cidade";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            CidadesBean c = new CidadesBean();
            c.setIdcidades(rs.getInt("idcidades"));
            c.setIdestados(rs.getInt("idestados"));
            c.setCidade(rs.getString("cidade"));
            c.setUf(rs.getString("uf"));
            lista.add(c);
        }
        stmt.close();        rs.close();        con.close();
        return lista;
    }
}

