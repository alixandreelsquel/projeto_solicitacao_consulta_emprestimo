package br.com.tqi.desafio.desafiotqi.repository.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity // Tabela no banco de dados dos emprestimos
@Table(name = "cliente")
public class Emprestimo {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Double valorParcela;

    @Column
    private String dataPrimeiraParcela;

    @Column
    private int qtdDeParcelas;

    @JsonBackReference
    @ManyToOne
    private Cliente cliente;

    public Emprestimo() {
    }

    public Emprestimo(Long id, Double valorParcela, String dataPrimeiraParcela, int qtdDeParcelas, Cliente cliente) {
        this.id = id;
        this.valorParcela = valorParcela;
        this.dataPrimeiraParcela = dataPrimeiraParcela;
        this.qtdDeParcelas = qtdDeParcelas;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public void setDataPrimeiraParcela(String dataPrimeiraParcela) {
        this.dataPrimeiraParcela = dataPrimeiraParcela;
    }

    public int getQtdDeParcelas() {
        return qtdDeParcelas;
    }

    public void setQtdDeParcelas(int qtdDeParcelas) {
        this.qtdDeParcelas = qtdDeParcelas;
    }
}
