package br.com.pay.models;

public class Account {
    Pay pay = new Pay();
    private double limite;
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public Account(double limite) {
        this.limite = limite;
    }

    public boolean compras(Product product) {
        if (this.saldo > product.getValor()) {
            this.saldo -= product.getValor();
            pay.getProdutos().add(product);
            return true;
        }
        return false;
    }
}
