package ufcg.edu.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufcg.edu.br.domain.ListaDeTarefaEntity;
import ufcg.edu.br.domain.TarefaEntity;
import ufcg.edu.br.form.ListaDeTarefa;
import ufcg.edu.br.form.Tarefa;
import ufcg.edu.br.repository.ListaDeTarefaRepository;
import ufcg.edu.br.repository.TarefaRepository;

@Controller
public class MainController {

  @Autowired
  private ListaDeTarefaRepository listaDeTarefaRep;

  @Autowired
  private TarefaRepository tarefaRep;


  private Model baseModel(Model model) {
    model.addAttribute("tarefa", new Tarefa());
    model.addAttribute("listas", listaDeTarefaRep.findAll());
    model.addAttribute("tarefas", tarefaRep.findAll());
    model.addAttribute("total",
        ((List<TarefaEntity>) tarefaRep.findByFeito(false)).size() + " Tarefa(s) a fazer");
    return model;
  }

  @PostMapping("/addLista")
  public String addLista(@ModelAttribute ListaDeTarefa listaDeTarefa, Model model) {
    listaDeTarefaRep.save(new ListaDeTarefaEntity(listaDeTarefa.getNome()));
    model.addAttribute("listas", listaDeTarefaRep.findAll());
    return "novalista";
  }

  @PostMapping("/addTarefa")
  public String addTarefa(@ModelAttribute Tarefa tarefa, Model model) {
    tarefaRep.save(new TarefaEntity(tarefa.getDescricao(), tarefa.getIdLista(),
        tarefa.getPrioridade(), tarefa.getCategoria(), tarefa.getIdSuper()));
    model.addAttribute("tarefas", tarefaRep.findAll());
    return "redirect:recuperartarefas?idLista=" + tarefa.getIdLista();
  }


  @GetMapping("/index")
  public String getIndex(Model model) {
    model = baseModel(model);
    return "index";
  }

  @PostMapping("/editartarefa")
  public String editarTarefa(@ModelAttribute Tarefa tarefa, @RequestParam Long id, Model model) {
    TarefaEntity novaTarefa = tarefaRep.findOne(id);
    novaTarefa.setDescricao(tarefa.getDescricao());
    novaTarefa.setCategoria(tarefa.getCategoria());
    novaTarefa.setFeito(tarefa.isFeito());
    tarefaRep.save(novaTarefa);
    return "redirect:recuperartarefas?idLista=" + novaTarefa.getIdLista();
  }

  @GetMapping("/editartarefa")
  public String irParaEditarTarefa(@RequestParam Long id, Model model) {
    model.addAttribute("tarefa", tarefaRep.findOne(id));
    return "editartarefa";
  }

  @GetMapping("/recuperartarefas")
  public String recuperarTarefas(@RequestParam Long idLista, Model model) {
    model = baseModel(model);
    model.addAttribute("tarefaslista", tarefaRep.findByidSuperAndIdLista((long) -1, idLista));
    return "index";
  }

  @GetMapping("/excluirlista")
  public String excluirLista(@RequestParam Long id) {
    listaDeTarefaRep.delete(listaDeTarefaRep.findOne(id));
    tarefaRep.delete(tarefaRep.findByIdLista(id));
    return "redirect:novalista";
  }

  @GetMapping("/excluirtarefa")
  public String excluirTarefa(@RequestParam Long id) {
    tarefaRep.delete(tarefaRep.findOne(id));
    tarefaRep.delete(tarefaRep.findByidSuper(id));
    return "redirect:index";
  }


  @GetMapping("/novalista")
  public String novaListaForm(Model model) {
    model.addAttribute("listaDeTarefa", new ListaDeTarefa());
    model.addAttribute("listas", listaDeTarefaRep.findAll());
    return "novalista";
  }

  @GetMapping("/")
  public String redirectIndex() {
    return "redirect:index";
  }

  @GetMapping("/contato")
  public String retirectContato() {
    return "contato";
  }

  @GetMapping("/tarefasfilha")
  public String getFilha(@RequestParam Long id, Model model) {
    model = baseModel(model);
    model.addAttribute("tarefasfilha", tarefaRep.findByidSuper(id));
    return "index";
  }

}
