package com.mycompany.desafiorestfull.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author chrystiantoigo
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MembroNotFoundException extends RuntimeException {
    public MembroNotFoundException(Long id) {
        super("Membro não encontrado com ID: " + id);
    }
}
