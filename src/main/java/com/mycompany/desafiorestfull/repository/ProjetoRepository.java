package com.mycompany.desafiorestfull.repository;

import com.mycompany.desafiorestfull.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author chrystiantoigo
 */

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
