package com.example.demomvc.controller;

import com.example.demomvc.entity.Tarefa;
import com.example.demomvc.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaApiController {

    private final TarefaService service;

    public TarefaApiController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        service.salvar(tarefa);
        return tarefa;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return service.buscaTodos();
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefa.setId(id);
        service.editar(tarefa);
        return tarefa;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
