package ufcg.edu.br.repository;

import ufcg.edu.br.domain.ListaDeTarefaEntity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ListaDeTarefaRepository extends CrudRepository<ListaDeTarefaEntity, Long> {
  List<ListaDeTarefaEntity> findByNome(String nome);
}
