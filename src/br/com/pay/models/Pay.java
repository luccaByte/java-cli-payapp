package br.com.pay.models;

import java.util.ArrayList;
import java.util.List;

public class Pay {
    private List<Product> produtos;

    public Pay() {
        this.produtos = new ArrayList<>();
    }

    public List<Product> getProdutos() {
        return produtos;
    }
}
