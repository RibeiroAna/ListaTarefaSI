package ufcg.edu.br.form;

import java.util.LinkedList;
import java.util.List;

public class ListaDeTarefa {

  private String nome;
  private List <Tarefa> listaDeTarefa = new LinkedList<Tarefa>();

  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public String getNome() {
    return nome;
  }
  
  public void addToListaDeTarefa(Tarefa tarefa) {
    listaDeTarefa.add(tarefa);
  }
  
  public List<Tarefa> getListaDeTarefa() {
    return listaDeTarefa;
  }
  
}
