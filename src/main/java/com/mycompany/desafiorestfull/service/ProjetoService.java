package com.mycompany.desafiorestfull.service;

import com.mycompany.desafiorestfull.exception.ProjetoNotFoundException;
import com.mycompany.desafiorestfull.exception.StatusInvalidoException;
import com.mycompany.desafiorestfull.model.Projeto;
import com.mycompany.desafiorestfull.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author chrystiantoigo
 */
@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> getAllProjetos() {
        return projetoRepository.findAll();
    }

    public Projeto getProjetoById(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new ProjetoNotFoundException(id));
    }

    public Projeto criarProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto atualizarProjeto(Long id, Projeto projeto) {
        if (!projetoRepository.existsById(id)) {
            throw new ProjetoNotFoundException(id);
        }
        projeto.setId(id);
        return projetoRepository.save(projeto);
    }

    public void excluirProjeto(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new ProjetoNotFoundException(id));

        if (statusPermiteExclusao(projeto.getStatus())) {
            projetoRepository.deleteById(id);
        } else {
            throw new StatusInvalidoException(projeto.getStatus());
        }
    }
    
    private boolean statusPermiteExclusao(String status) {
        return !"iniciado".equalsIgnoreCase(status) &&
               !"em andamento".equalsIgnoreCase(status) &&
               !"encerrado".equalsIgnoreCase(status);
    }
}
