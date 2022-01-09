package br.com.tqi.desafio.desafiotqi.repository.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity // Tabela no banco de dados
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue
    private Long id; // Para diferenciar os cliente

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String cpf;

    @Column
    private String rg;

    @Column
    private String endereco;

    @Column
    private Double renda;

    @Column
    private String senha;

    @Column
    private Boolean isLogged;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<Emprestimo> emprestimos;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String cpf, String rg, String endereco, Double renda, String senha, Boolean isLogged, List<Emprestimo> emprestimos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.renda = renda;
        this.senha = senha;
        this.isLogged = isLogged;
        this.emprestimos = emprestimos;
    }

    public Boolean getLogged() {
        return isLogged;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
