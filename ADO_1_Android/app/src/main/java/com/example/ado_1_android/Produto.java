package com.example.ado_1_android;

import java.io.Serializable;

public class Produto implements Serializable {
    @Override
    public String toString() {
        return "Produto{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", precoCompra=" + precoCompra +
                ", precoVenda=" + precoVenda +
                '}';
    }

    private String nomeProduto;
    private Double precoCompra;
    private Double precoVenda;
    private Double lucro;

    public Produto() {
    }

    public Produto(String nomeProduto, Double precoCompra, Double precoVenda) {
        this.nomeProduto = nomeProduto;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
    }

    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }
}
