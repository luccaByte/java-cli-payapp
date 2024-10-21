package br.com.pay.models;

public class Product {
    private String descricao;
    private double valor;

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public Product(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Compras: [" + "descricao: " + descricao + '\'' +
                ", valor: " + valor + "]";
    }
}
