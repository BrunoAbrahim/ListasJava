package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaRotas lista = new ListaRotas();

        System.out.print("Digite o tipo de transporte ou região desejada: ");
        String filtro = sc.nextLine();

        lista.carregarDeArquivo("rotas_de_transportes.txt", filtro);

        System.out.println("\n--- Rotas em ordem normal ---");
        lista.exibirOrdemNormal();

        System.out.println("\n--- Rotas em ordem inversa ---");
        lista.exibirOrdemInversa();

        lista.liberar();

        sc.close();
    }
}
