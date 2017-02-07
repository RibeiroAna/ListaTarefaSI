package ufcg.edu.br.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Tarefa")
@Table(name = "tb_tarefa")
public class TarefaEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String descricao;
  
  @Column
  private Long idLista;
  
  @Column
  private String prioridade;
  
  @Column
  private boolean feito;
  
  @Column
  private Long idSuper;
  
  @Column
  private String categoria;
  
  public TarefaEntity(String descricao, Long idLista, String prioridade, String categoria, long idSuper) {
    this.descricao = descricao;
    this.idLista = idLista;
    this.prioridade = prioridade;
    this.feito = false;
    this.categoria = categoria;
    this.idSuper = idSuper;
  }
  
  public Long getIdSuperTarefa() {
    return idSuper;
  }

  public void setIdSuperTarefa(Long idSuperTarefa) {
    this.idSuper = idSuperTarefa;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public TarefaEntity() {
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  
  public String getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(String prioridade) {
    this.prioridade = prioridade;
  }

  public boolean isFeito() {
    return feito;
  }

  public void setFeito(boolean feito) {
    this.feito = feito;
  }

  public Long getIdLista() {
    return idLista;
  }
  
  public void setIdLista(Long idLista) {
    this.idLista = idLista;
  }
  
}
