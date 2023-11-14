package com.mycompany.desafiorestfull.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author chrystiantoigo
 */
@Entity
public class Membro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;

    private String atribuicao;
    
    @ManyToOne
    @JoinColumn(name = "idprojeto")
    private Projeto projeto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @ManyToOne
    @JoinColumn(name = "idpessoa")
    private Pessoa pessoa;

     public String getAtribuicao() {
        return atribuicao;
    }

    public void setAtribuicao(String atribuicao) {
        this.atribuicao = atribuicao;
    }
    
}
