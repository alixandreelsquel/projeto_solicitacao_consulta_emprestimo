package br.com.tqi.desafio.desafiotqi.controller.response;

import br.com.tqi.desafio.desafiotqi.repository.model.Cliente;
import br.com.tqi.desafio.desafiotqi.repository.model.Emprestimo;

import java.util.Date;

public class SolicitarEmprestimoResponse {
    private Double valorParcela;
    private String dataPrimeiraParcela;
    private int qtdDeParcelas;
    private Cliente cliente;

    public SolicitarEmprestimoResponse() {
    }

    public SolicitarEmprestimoResponse(Double valorParcela, String dataPrimeiraParcela, int qtdDeParcelas, Cliente cliente) {
        this.valorParcela = valorParcela;
        this.dataPrimeiraParcela = dataPrimeiraParcela;
        this.qtdDeParcelas = qtdDeParcelas;
        this.cliente = cliente;
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

    public static SolicitarEmprestimoResponse toSolicitarEmprestimoResponse(Emprestimo emprestimo) {
        SolicitarEmprestimoResponse solicitarEmprestimoResponse = new SolicitarEmprestimoResponse();
        emprestimo.getCliente().setEmprestimos(null);
        solicitarEmprestimoResponse.setCliente(emprestimo.getCliente());
        solicitarEmprestimoResponse.setQtdDeParcelas(emprestimo.getQtdDeParcelas());
        solicitarEmprestimoResponse.setValorParcela(emprestimo.getValorParcela());
        solicitarEmprestimoResponse.setDataPrimeiraParcela(emprestimo.getDataPrimeiraParcela());

        return solicitarEmprestimoResponse;

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}