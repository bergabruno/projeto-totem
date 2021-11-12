package br.fiap.entities;

public class Totem {

  private int idTotem;

  private int idEmpresa;

  private String pais;

  private String cidade;

  private String bairro;

  private String longitude;

  private String latitude;

  public Totem(int idTotem, String pais, String cidade, String bairro, String longitude,
      String latitude) {
    super();
    this.idTotem = idTotem;
    this.pais = pais;
    this.cidade = cidade;
    this.bairro = bairro;
    this.longitude = longitude;
    this.latitude = latitude;
    this.idEmpresa = 1001;
  }

  public int getIdTotem() {
    return idTotem;
  }

  public void setIdTotem(int idTotem) {
    this.idTotem = idTotem;
  }

  public int getIdEmpresa() {
    return idEmpresa;
  }

  public void setIdEmpresa(int idEmpresa) {
    this.idEmpresa = idEmpresa;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

}
