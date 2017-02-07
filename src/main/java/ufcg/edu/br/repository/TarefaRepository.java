package ufcg.edu.br.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ufcg.edu.br.domain.TarefaEntity;

public interface TarefaRepository extends CrudRepository<TarefaEntity, Long> {
  List<TarefaEntity> findByDescricao(String descricao);
  List<TarefaEntity> findByIdLista(Long idLista);
  List<TarefaEntity> findByidSuper(Long idSuper);
  List<TarefaEntity> findByFeito(boolean feito);
  List<TarefaEntity> findByidSuperAndIdLista(Long idSuper, Long idLista);  
}
