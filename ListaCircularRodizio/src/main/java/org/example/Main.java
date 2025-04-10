package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resposta;

        System.out.println("=== Sistema de Rodízio de Veículos ===");

        do {
            System.out.print("\nInforme o critério de busca (dia da semana ou final da placa): ");
            String criterio = sc.nextLine().trim();

            ListaCircular lista = new ListaCircular();
            lista.carregarDeArquivo("rodizio_de_veiculos.txt", criterio);
            lista.exibir();

            System.out.print("\nDeseja buscar por outro dia específico? (s/n): ");
            resposta = sc.nextLine().trim().toLowerCase();

        } while (resposta.equals("s"));

        System.out.println("Programa encerrado.");
        sc.close();
    }
}
