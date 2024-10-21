package br.com.pay.models;

import java.util.ArrayList;
import java.util.List;

public class Pay {
    private List<Product> produtos;

    public Pay() {}

    public List<Product> getProdutos() {
        return produtos;
    }

    public Pay(List<Product> produtos) {
        this.produtos = new ArrayList<>();
    }
}
