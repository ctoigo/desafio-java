package com.mycompany.desafiorestfull.repository;

import com.mycompany.desafiorestfull.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author chrystiantoigo
 */
public interface MembroRepository extends JpaRepository<Membro, Long> {
}
