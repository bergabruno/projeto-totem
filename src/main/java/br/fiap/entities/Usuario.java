package br.fiap.entities;

public class Usuario {

  private int id;
  
  private String nome;
  
  private String sobrenome;
  
  private int idade;
  
  private int codBarras;
  
  private int matricula;

  public Usuario(int id, String nome, String sobrenome, int idade, int codBarras, int matricula) {
    super();
    this.id = id;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.idade = idade;
    this.codBarras = codBarras;
    this.matricula = matricula;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public int getCodBarras() {
    return codBarras;
  }

  public void setCodBarras(int codBarras) {
    this.codBarras = codBarras;
  }

  public int getMatricula() {
    return matricula;
  }

  public void setMatricula(int matricula) {
    this.matricula = matricula;
  }
  
  
}
