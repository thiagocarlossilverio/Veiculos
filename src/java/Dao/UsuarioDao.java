package Dao;

import Bean.UsuarioBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Util.Conexao;

public class UsuarioDao {

    public static void salvar(UsuarioBean u) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "insert into usuario (nome, cpf, telefone, email, usuario, senha,tipo, status) values "
                + "(?,?,?,?,?,?,?,'ativo')";


        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getCpf());
        stmt.setString(3, u.getTelefone());
        stmt.setString(4, u.getEmail());
        stmt.setString(5, u.getUsuario());
        stmt.setString(6, u.getSenha());
        stmt.setString(7, u.getTipo());

        stmt.execute();
        con.close();
    }

    public static void alterar(UsuarioBean u) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "UPDATE usuario SET nome=?, cpf=?, telefone=?, email=?, usuario=?, senha=?,tipo=?, status =? WHERE idusuario =?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getCpf());
        stmt.setString(3, u.getTelefone());
        stmt.setString(4, u.getEmail());
        stmt.setString(5, u.getUsuario());
        stmt.setString(6, u.getSenha());
        stmt.setString(7, u.getTipo());
        stmt.setString(8, u.getStatus());

        stmt.executeUpdate();
        con.close();
    }

    public static void excluir(UsuarioBean use) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "delete from usuario where idusuario=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, use.getNome());
        stmt.setString(2, use.getCpf());
        stmt.setString(3, use.getTelefone());
        stmt.setString(4, use.getEmail());
        stmt.setString(5, use.getUsuario());
        stmt.setString(6, use.getSenha());
        stmt.setString(7, use.getTipo());
        stmt.setString(8, use.getStatus());
        stmt.executeUpdate();
        con.close();
    }

    public static List<UsuarioBean> getLista() throws SQLException {
        List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
        Connection con = Conexao.getConnection();
        String sql = "select * from usuario order by nome";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            UsuarioBean u = new UsuarioBean();
            u.setIdusuario(rs.getInt("idusuario"));
            u.setNome(rs.getString("nome"));
            u.setCpf(rs.getString("cpf"));
            u.setTelefone(rs.getString("telefone"));
            u.setEmail(rs.getString("email"));
            u.setUsuario(rs.getString("usuario"));
            u.setSenha(rs.getString("senha"));
            u.setTipo(rs.getString("tipo"));
            u.setStatus(rs.getString("status"));
            lista.add(u);
        }
        stmt.close();
        rs.close();
        con.close();
        return lista;
    }

    public static UsuarioBean getUsuario(int id) throws SQLException {
        UsuarioBean use = new UsuarioBean();
        Connection con = Conexao.getConnection();
        String sql = "select * from usuario where idusuario =" + id;
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        UsuarioBean u = new UsuarioBean();
        u.setIdusuario(rs.getInt("idUsuario"));
        u.setNome(rs.getString("nome"));
        u.setCpf(rs.getString("cpf"));
        u.setTelefone(rs.getString("telefone"));
        u.setUsuario(rs.getString("usuario"));
        u.setSenha(rs.getString("senha"));
        u.setEmail(rs.getString("email"));
        u.setDatacadastro(rs.getDate("dataCadastro"));

        stmt.close();
        rs.close();
        con.close();
        return u;
    }

    public String logar(String usuaio, String senha) {
        String falha = "falha";
        try {
            Connection con = Conexao.getConnection();
            String sql = "select * from usuario where usuario.usuario = '" + usuaio + "' and usuario.senha= '" + senha + "';";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            UsuarioBean u = new UsuarioBean();
            u.setIdusuario(rs.getInt("idusuario"));
            u.setNome(rs.getString("nome"));
            u.setCpf(rs.getString("cpf"));
            u.setTelefone(rs.getString("telefone"));
            u.setUsuario(rs.getString("usuario"));
            u.setSenha(rs.getString("senha"));
            u.setEmail(rs.getString("email"));
           

            stmt.close();
            rs.close();
            con.close();
            falha = "sucesso";
        } catch (Exception e) {
            falha = "falha";
            e.printStackTrace();
        }
        return falha;
    }
}
