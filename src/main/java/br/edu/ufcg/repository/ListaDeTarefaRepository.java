package br.edu.ufcg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ufcg.domain.ListaDeTarefaEntity;

public interface ListaDeTarefaRepository extends CrudRepository<ListaDeTarefaEntity, Long> {
  List<ListaDeTarefaEntity> findByNome(String nome);
}
