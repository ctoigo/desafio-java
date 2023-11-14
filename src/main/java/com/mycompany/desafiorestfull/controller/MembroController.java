package com.mycompany.desafiorestfull.controller;

import com.mycompany.desafiorestfull.model.Membro;
import com.mycompany.desafiorestfull.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author chrystiantoigo
 */
@RestController
@RequestMapping("/api/membros")
public class MembroController {

    @Autowired
    private MembroService membroService;

    // Endpoint para obter todos os membros
    @GetMapping
    public List<Membro> getAllMembros() {
        return membroService.getAllMembros();
    }

    // Endpoint para criar um novo membro
    @PostMapping
    public Membro criarMembro(@RequestBody Membro membro) {
        return membroService.criarMembro(membro);
    }
    
     // Endpoint para associar um membro a um projeto
    @PostMapping("/{membroId}/associar-projeto/{projetoId}")
    public Membro associarMembroAProjeto(@PathVariable Long membroId, @PathVariable Long projetoId) {
        return membroService.associarMembroAProjeto(membroId, projetoId);
    }

    // Endpoint para desassociar um membro de um projeto
    @PostMapping("/{membroId}/desassociar-projeto")
    public Membro desassociarMembroDeProjeto(@PathVariable Long membroId) {
        return membroService.desassociarMembroDeProjeto(membroId);
    }
}
