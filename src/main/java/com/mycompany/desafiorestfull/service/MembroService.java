package com.mycompany.desafiorestfull.service;

import com.mycompany.desafiorestfull.exception.AtribuicaoInvalidaException;
import com.mycompany.desafiorestfull.exception.MembroNotFoundException;
import com.mycompany.desafiorestfull.exception.ProjetoNotFoundException;
import com.mycompany.desafiorestfull.model.Membro;
import com.mycompany.desafiorestfull.model.Projeto;
import com.mycompany.desafiorestfull.repository.MembroRepository;
import com.mycompany.desafiorestfull.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author chrystiantoigo
 */
@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Membro> getAllMembros() {
        return membroRepository.findAll();
    }

    public Membro criarMembro(Membro membro) {
        return membroRepository.save(membro);
    }
    
    public Membro associarMembroAProjeto(Long membroId, Long projetoId) {
        Membro membro = membroRepository.findById(membroId)
                .orElseThrow(() -> new MembroNotFoundException(membroId));

        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new ProjetoNotFoundException(projetoId));

        // Verifica se o membro tem a atribuição "funcionário"
        if ("funcionário".equalsIgnoreCase(membro.getAtribuicao())) {
            membro.setProjeto(projeto);
            return membroRepository.save(membro);
        } else {
            throw new AtribuicaoInvalidaException(membro.getAtribuicao());
        }
    }

    public Membro desassociarMembroDeProjeto(Long membroId) {
        Membro membro = membroRepository.findById(membroId)
                .orElseThrow(() -> new MembroNotFoundException(membroId));

        // Desassocia o membro do projeto
        membro.setProjeto(null);
        return membroRepository.save(membro);
    }
}
