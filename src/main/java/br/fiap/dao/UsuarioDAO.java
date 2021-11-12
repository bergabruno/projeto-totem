package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entities.Usuario;

public class UsuarioDAO {

  private ResultSet rs;
  private PreparedStatement ps;
  private String sql;
  private Connection connection;
  
  
  public UsuarioDAO() {
    connection = Conexao.conectar();
  }
  
  
  public void inserir(Usuario usuario) {
    sql = "insert into tb_usuario values (?,?,?,?,?,?)";
    try {
      ps = connection.prepareStatement(sql);
      ps.setInt(1, usuario.getId());
      ps.setString(2, usuario.getNome());
      ps.setString(3, usuario.getSobrenome());
      ps.setInt(4, usuario.getIdade());
      ps.setInt(5, usuario.getCodBarras()); //TODO alterar para String
      ps.setInt(6, usuario.getMatricula());
      ps.execute();
    }catch (SQLException e) {
      System.out.println(e);
    }
  }
  
  public List<Usuario> obterTodos(){
    List<Usuario> lista = new ArrayList<>();
    sql = "select * from tb_usuario order by id_usuario";
    try {
    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();
    while(rs.next()) {
      lista.add(new Usuario(rs.getInt("id_usuario"),rs.getString("nome"), 
          rs.getString("sobrenome"),rs.getInt("idade"), rs.getInt("cd_barras"), rs.getInt("matricula")));
    }
    }catch(SQLException e) {
      System.out.println(e);
    }

    return lista;
  }
  
 
  
  public boolean buscar(int id) {
    sql = "select * from tb_usuario where id_usuario = ? ";
    
    try {
      ps = connection.prepareStatement(sql);
      ps.setInt(1, id);
      rs = ps.executeQuery();
      if(rs.next()) {
        return true;
      }
    }catch(SQLException e) {
      System.out.println(e);
    }
    return false;
  }
  
 
  

}
