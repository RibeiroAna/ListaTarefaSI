package br.edu.ufcg.form;

public class Tarefa {

  private Long id;
  private String descricao;
  private Long idLista;
  private String prioridade;
  private boolean feito;
  private Long idSuper;
  private String categoria;

  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Long getIdSuper() {
    return idSuper;
  }

  public void setIdSuper(Long idSuper) {
    this.idSuper = idSuper;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public boolean isFeito() {
    return feito;
  }

  public void setFeito(boolean feito) {
    this.feito = feito;
  }

  public String getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(String prioridade) {
    this.prioridade = prioridade;
  }

  public String getDescricao() {
    return descricao;
  }

  public Long getIdLista() {
    return idLista;
  }

  public void setIdLista(Long idLista) {
    this.idLista = idLista;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  
}
