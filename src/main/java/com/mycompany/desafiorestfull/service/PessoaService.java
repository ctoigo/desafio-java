package com.mycompany.desafiorestfull.service;

import com.mycompany.desafiorestfull.model.Pessoa;
import com.mycompany.desafiorestfull.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author chrystiantoigo
 */

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    // Outros métodos relacionados a Pessoa
}
