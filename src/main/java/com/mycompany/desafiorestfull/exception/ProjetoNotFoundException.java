package com.mycompany.desafiorestfull.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author chrystiantoigo
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjetoNotFoundException extends RuntimeException {
    public ProjetoNotFoundException(Long id) {
        super("Projeto não encontrado com ID: " + id);
    }
}
