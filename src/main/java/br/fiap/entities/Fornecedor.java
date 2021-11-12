package br.fiap.entities;

public class Fornecedor {

  private int idFornecedor;

  private int idEmpresa;

  private String nome;

  private String cnpj;

  private String cpf;

  private double valor;

  public Fornecedor(int idFornecedor, String nome, String cnpj, String cpf, double valor) {
    super();
    this.idFornecedor = idFornecedor;
    this.nome = nome;
    this.cnpj = cnpj;
    this.cpf = cpf;
    this.valor = valor;
    this.idEmpresa = 1001;
  }

  public int getIdFornecedor() {
    return idFornecedor;
  }

  public void setIdFornecedor(int idFornecedor) {
    this.idFornecedor = idFornecedor;
  }

  public int getIdEmpresa() {
    return idEmpresa;
  }

  public void setIdEmpresa(int idEmpresa) {
    this.idEmpresa = idEmpresa;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

}
