package br.com.tqi.desafio.desafiotqi.controller.response;

import br.com.tqi.desafio.desafiotqi.repository.model.Cliente;

public class CadastroClienteResponse {

    private Long idCliente;
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private String endereco;
    private Double renda;
    private String senha;

    public CadastroClienteResponse() {
    }

    public CadastroClienteResponse(Long idCliente, String nome, String email, String cpf, String rg, String endereco, Double renda, String senha) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.renda = renda;
        this.senha = senha;
    }

    public Double getRenda() {
        return renda;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static CadastroClienteResponse toCadastroClienteResponse(Cliente cliente){
        CadastroClienteResponse cadastroClienteResponse = new CadastroClienteResponse();
        cadastroClienteResponse.setIdCliente(cliente.getId());
        cadastroClienteResponse.setSenha(cliente.getEndereco());
        cadastroClienteResponse.setRenda(cliente.getRenda());
        cadastroClienteResponse.setRg(cliente.getRg());
        cadastroClienteResponse.setCpf(cliente.getCpf());
        cadastroClienteResponse.setEmail(cliente.getEmail());
        cadastroClienteResponse.setNome(cliente.getNome());
        cadastroClienteResponse.setEndereco(cliente.getEndereco());

        return cadastroClienteResponse;

    }
}
