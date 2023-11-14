package com.mycompany.desafiorestfull.controller;

import com.mycompany.desafiorestfull.model.Projeto;
import com.mycompany.desafiorestfull.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author chrystiantoigo
 */
@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    // Endpoint para obter todos os projetos
    @GetMapping
    public List<Projeto> getAllProjetos() {
        return projetoService.getAllProjetos();
    }

    // Endpoint para obter um projeto por ID
    @GetMapping("/{id}")
    public Projeto getProjetoById(@PathVariable Long id) {
        return projetoService.getProjetoById(id);
    }

    // Endpoint para criar um novo projeto
    @PostMapping
    public Projeto criarProjeto(@RequestBody Projeto projeto) {
        return projetoService.criarProjeto(projeto);
    }

    // Endpoint para atualizar um projeto existente
    @PutMapping("/{id}")
    public Projeto atualizarProjeto(@PathVariable Long id, @RequestBody Projeto projeto) {
        return projetoService.atualizarProjeto(id, projeto);
    }

    // Endpoint para excluir um projeto
    @DeleteMapping("/{id}")
    public void excluirProjeto(@PathVariable Long id) {
        projetoService.excluirProjeto(id);
    }
    
    // Endpoint para classificar o risco de um projeto existente
    @PutMapping("/{id}/classificar-risco")
    public Projeto classificarRisco(@PathVariable Long id, @RequestParam String risco) {
        Projeto projeto = projetoService.getProjetoById(id);
        projeto.setRisco(risco);
        return projetoService.atualizarProjeto(id, projeto);
    }
    
    // Endpoint para alterar o status de um projeto existente
    @PutMapping("/{id}/alterar-status")
    public Projeto alterarStatus(@PathVariable Long id, @RequestParam String novoStatus) {
        Projeto projeto = projetoService.getProjetoById(id);
        projeto.setStatus(novoStatus);
        return projetoService.atualizarProjeto(id, projeto);
    }
}
