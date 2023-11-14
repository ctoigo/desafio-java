package com.mycompany.desafiorestfull.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author chrystiantoigo
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AtribuicaoInvalidaException extends RuntimeException {
    public AtribuicaoInvalidaException(String atribuicao) {
        super("Atribuição inválida para associar membro a um projeto: " + atribuicao);
    }
}
