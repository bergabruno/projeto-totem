package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entities.Totem;

public class TotemDAO {

  private ResultSet rs;
  private PreparedStatement ps;
  private String sql;
  private Connection connection;
  
  
  public TotemDAO() {
    connection = Conexao.conectar();
  }
  
  
  public void inserir(Totem totem) {
    sql = "insert into tb_totem values (?,?,?,?,?,?,?)";
    try {
      ps = connection.prepareStatement(sql);
      ps.setInt(1, totem.getIdTotem());
      ps.setInt(2, 1001);
      ps.setString(3, totem.getPais());
      ps.setString(4, totem.getCidade());
      ps.setString(5, totem.getBairro());
      ps.setString(6, totem.getLongitude());
      ps.setString(7, totem.getLatitude());
      ps.execute();
    }catch (SQLException e) {
      System.out.println(e);
    }
  }
  
  public List<Totem> obterTodos(){
    List<Totem> lista = new ArrayList<>();
    sql = "select * from tb_totem order by id_totem";
    try {
    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();
    while(rs.next()) {
      lista.add(new Totem(rs.getInt("id_totem"), 
          rs.getString("pais"),rs.getString("cidade"), rs.getString("bairro"), 
          rs.getString("longitude"),rs.getString("latitude")));
    }
    }catch(SQLException e) {
      System.out.println(e);
    }

    return lista;
  }
}
