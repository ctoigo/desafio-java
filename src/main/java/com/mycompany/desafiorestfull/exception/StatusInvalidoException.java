package com.mycompany.desafiorestfull.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author chrystiantoigo
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StatusInvalidoException extends RuntimeException {
    public StatusInvalidoException(String status) {
        super("Não é possível excluir um projeto com o status: " + status);
    }
}
