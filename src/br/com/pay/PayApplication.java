package br.com.pay;

import br.com.pay.models.Account;
import br.com.pay.models.Product;

import java.util.Collections;
import java.util.Scanner;

public class PayApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account(1000);
        int menu;

        do {
            System.out.print("""
            -----------------------------------
            Menu de compras

            1 - Ver o limite atual do cartão
            2 - Adicionar produto ao cartão
            3 - Visualizar compras no cartão
            0 - Sair
            -----------------------------------
            """);

            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("Saldo do cartão:         R$ " + account.getLimite());
                    break;
                case 2:
                    criandoProduto(sc, account);
                    break;
                case 3:
                    ordenandoProdutos(account);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (menu != 0);

        sc.close();
    }

    private static void criandoProduto(Scanner sc, Account account) {
        int menu = 1;

        while (menu != 0) {
            System.out.println("Digite o nome do produto:");
            String descricao = sc.nextLine();
            System.out.println("Digite o valor do produto:");
            double valor = sc.nextDouble();
            sc.nextLine();

            Product product = new Product(descricao, valor);

            boolean verificacao = account.validacaoCompra(product);

            if (verificacao) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                menu = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Saldo insuficiente!");
                break;
            }
        }
    }

    private static void ordenandoProdutos(Account account) {
        System.out.println("""
        -----------------------------------
        COMPRAS REALIZADAS
        """);

        Collections.sort(account.getPay().getProdutos());

        for (Product item : account.getPay().getProdutos()) {
            System.out.println(item.getDescricao() + " - R$ " + item.getValor());
        }
        System.out.printf("""
        \nSaldo do cartão:         R$ %.2f
        -----------------------------------\n""", account.getLimite());
    }
}
