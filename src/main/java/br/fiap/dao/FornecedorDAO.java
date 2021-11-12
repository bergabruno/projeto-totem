package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entities.Fornecedor;

public class FornecedorDAO {
  private ResultSet rs;
  private PreparedStatement ps;
  private String sql;
  private Connection connection;
  
  
  public FornecedorDAO() {
    connection = Conexao.conectar();
  }
  
  
  public void inserir(Fornecedor fornecedor) {
    sql = "insert into tb_fornecedor values (?,?,?,?,?,?)";
    try {
      ps = connection.prepareStatement(sql);
      ps.setInt(1, fornecedor.getIdFornecedor());
      ps.setInt(2, 1001);
      ps.setString(3, fornecedor.getNome());
      ps.setString(4, fornecedor.getCnpj());
      ps.setString(5, fornecedor.getCpf());
      ps.setDouble(6, fornecedor.getValor());
      ps.execute();
    }catch (SQLException e) {
      System.out.println(e);
    }
  }
  
  public List<Fornecedor> obterTodos(){
    List<Fornecedor> lista = new ArrayList<>();
    sql = "select * from tb_fornecedor order by id_fornecedor";
    try {
    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();
    while(rs.next()) {
      lista.add(new Fornecedor(rs.getInt("id_fornecedor"), 
          rs.getString("nm_fornecedor"),rs.getString("cnpj"), rs.getString("cpf"), 
          rs.getDouble("vl_doado")));
    }
    }catch(SQLException e) {
      System.out.println(e);
    }

    return lista;
  }
}
