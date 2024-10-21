package br.com.pay;

import br.com.pay.models.Account;
import br.com.pay.models.Pay;
import br.com.pay.models.Product;

import java.util.Scanner;

public class PayApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pay pay = new Pay();
        Account account = new Account(1000);
        int menu;
        
        do {
            System.out.print("""
            -----------------------------------
            Menu de compras
            
            1 - Ver o limite atual do cartão
            2 - Adicionar produto ao cartão
            0 - Sair
            -----------------------------------
            """);

            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("Limite atual: R$ " + account.getLimite());
                    break;
                case 2:
                    criandoProduto(sc, account);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
            }
        } while (menu != 0);
        
        sc.close();
    }

    private  static  void criandoProduto(Scanner sc, Account account) {
        System.out.println("Digite o nome do produto:");
        String descricao = sc.nextLine();
        System.out.println("Digite o valor do produto:");
        double valor = sc.nextDouble();

        Product product = new Product(descricao, valor);

        boolean verificacao = account.validacaoCompra(product);

        if (verificacao) {
            System.out.println("Compra realizada!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}
