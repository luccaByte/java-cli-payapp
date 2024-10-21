package br.com.pay.models;

public class Account {
    Pay pay = new Pay();
    private double limite;

    public double getLimite() {
        return limite;
    }

    public Account(double limite) {
        this.limite = limite;
    }

    public boolean validacaoCompra(Product product) {
        if (this.limite >= product.getValor()) {
            this.limite -= product.getValor();
            pay.getProdutos().add(product);
            return true;
        }
        return false;
    }
}
