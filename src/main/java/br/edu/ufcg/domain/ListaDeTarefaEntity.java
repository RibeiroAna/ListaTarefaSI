package br.edu.ufcg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ListaDeTarefa")
@Table(name = "tb_lista_de_tarefa")
public class ListaDeTarefaEntity  {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column
  private String nome;
  
  public ListaDeTarefaEntity() {
  }
  
  public ListaDeTarefaEntity(String nome) {
      this.nome = nome;
  }
  
  public Long getId() {
      return id;
  }
  
  public void setId(Long id) {
      this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  
}
