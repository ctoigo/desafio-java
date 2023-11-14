package com.mycompany.desafiorestfull.repository;

import com.mycompany.desafiorestfull.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author chrystiantoigo
 */

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
