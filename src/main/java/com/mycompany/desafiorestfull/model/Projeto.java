package com.mycompany.desafiorestfull.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author chrystiantoigo
 */

@Entity
public class Projeto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dataInicio;
    private Date dataPrevisaoFim;
    private Date dataFim;
    private String descricao;
    private String status;
    private float orcamento;
    private String risco;

    @ManyToOne
    @JoinColumn(name = "idgerente")
    private Pessoa gerente;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Membro> membros;    
    // construtores, getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public void setDataPrevisaoFim(Date dataPrevisaoFim) {
        this.dataPrevisaoFim = dataPrevisaoFim;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public Pessoa getGerente() {
        return gerente;
    }

    public void setGerente(Pessoa gerente) {
        this.gerente = gerente;
    }
    
     public List<Membro> getMembros() {
        return membros;
    }
     
     public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }
}
