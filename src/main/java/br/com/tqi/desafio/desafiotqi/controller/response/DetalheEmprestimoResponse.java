package br.com.tqi.desafio.desafiotqi.controller.response;

import br.com.tqi.desafio.desafiotqi.repository.model.Cliente;
import br.com.tqi.desafio.desafiotqi.repository.model.Emprestimo;

public class DetalheEmprestimoResponse {
    private Long codigoDoEmprestimo;
    private Double valorDoEmprestimo;
    private int qtdDeParcelas;
    private String dataDaPrimeiraParcela;
    private String email;
    private Double renda;

    public DetalheEmprestimoResponse() {
    }

    public DetalheEmprestimoResponse(Long codigoDoEmprestimo, Double valorDoEmprestimo, int qtdDeParcelas, String dataDaPrimeiraParcela, String email, Double renda) {
        this.codigoDoEmprestimo = codigoDoEmprestimo;
        this.valorDoEmprestimo = valorDoEmprestimo;
        this.qtdDeParcelas = qtdDeParcelas;
        this.dataDaPrimeiraParcela = dataDaPrimeiraParcela;
        this.email = email;
        this.renda = renda;
    }

    public static DetalheEmprestimoResponse toDetalheEmprestimoResponse(Emprestimo emprestimo, Cliente cliente) {
        DetalheEmprestimoResponse detalheEmprestimoResponse = new DetalheEmprestimoResponse();
        detalheEmprestimoResponse.setCodigoDoEmprestimo(emprestimo.getId());
        detalheEmprestimoResponse.setValorDoEmprestimo(emprestimo.getValorParcela()*emprestimo.getQtdDeParcelas());
        detalheEmprestimoResponse.setDataDaPrimeiraParcela(emprestimo.getDataPrimeiraParcela());
        detalheEmprestimoResponse.setQtdDeParcelas(emprestimo.getQtdDeParcelas());
        detalheEmprestimoResponse.setEmail(cliente.getEmail());
        detalheEmprestimoResponse.setRenda(cliente.getRenda());


        return detalheEmprestimoResponse;

    }

    public Long getCodigoDoEmprestimo() {
        return codigoDoEmprestimo;
    }

    public void setCodigoDoEmprestimo(Long codigoDoEmprestimo) {
        this.codigoDoEmprestimo = codigoDoEmprestimo;
    }

    public Double getValorDoEmprestimo() {
        return valorDoEmprestimo;
    }

    public void setValorDoEmprestimo(Double valorDoEmprestimo) {
        this.valorDoEmprestimo = valorDoEmprestimo;
    }

    public int getQtdDeParcelas() {
        return qtdDeParcelas;
    }

    public void setQtdDeParcelas(int qtdDeParcelas) {
        this.qtdDeParcelas = qtdDeParcelas;
    }

    public String getDataDaPrimeiraParcela() {
        return dataDaPrimeiraParcela;
    }

    public void setDataDaPrimeiraParcela(String dataDaPrimeiraParcela) {
        this.dataDaPrimeiraParcela = dataDaPrimeiraParcela;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }
}
