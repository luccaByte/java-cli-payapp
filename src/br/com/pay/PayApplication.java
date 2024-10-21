package br.com.pay;

import br.com.pay.models.Account;
import br.com.pay.models.Pay;

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

            switch (menu) {
                case 1:
                    System.out.println("Limite atual: R$ " + account.getLimite());
                    break;
                case 2:
                    System.out.println("Nome do produto:");
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
            }
        } while (menu != 0);
        
        sc.close();
    }
}
