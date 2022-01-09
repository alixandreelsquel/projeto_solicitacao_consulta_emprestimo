package br.com.tqi.desafio.desafiotqi.controller.request;

public class SolicitarEmprestimoRequest {

    private Double valorParcela;
    private String dataPrimeiraParcela;
    private int qtdDeParcelas;
    private Long idCliente;

    public SolicitarEmprestimoRequest() {
    }

    public SolicitarEmprestimoRequest(Double valorParcela, String dataPrimeiraParcela, int qtdDeParcelas, Long idCliente) {
        this.valorParcela = valorParcela;
        this.dataPrimeiraParcela = dataPrimeiraParcela;
        this.qtdDeParcelas = qtdDeParcelas;
        this.idCliente = idCliente;
    }

    public String getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public void setDataPrimeiraParcela(String dataPrimeiraParcela) {
        this.dataPrimeiraParcela = dataPrimeiraParcela;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;

    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public int getQtdDeParcelas() {
        return qtdDeParcelas;
    }

    public void setQtdDeParcelas(int qtdDeParcelas) {
        this.qtdDeParcelas = qtdDeParcelas;
    }
}
