package com.mycompany.desafiorestfull.controller;

import com.mycompany.desafiorestfull.model.Pessoa;
import com.mycompany.desafiorestfull.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
 * @author chrystiantoigo
 */
@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.cadastrarPessoa(pessoa);
    }

    // Outros endpoints relacionados a Pessoa
}
