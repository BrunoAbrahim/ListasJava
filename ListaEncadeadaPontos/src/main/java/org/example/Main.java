package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista = new ListaEncadeada();

        System.out.print("Digite o tipo de material que deseja buscar (ex: Plástico, Vidro, Eletrônicos): ");
        String filtro = scanner.nextLine().trim().toLowerCase();

        File arquivo = new File("pontos_de_descarte.txt");

        if (!arquivo.exists()) {
            System.out.println("Erro: Arquivo não encontrado em " + arquivo.getAbsolutePath());
            return;
        }

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(";", 3);

                if (partes.length == 3) {
                    int id;
                    try {
                        id = Integer.parseInt(partes[0].trim());
                    } catch (NumberFormatException e) {
                        continue; 
                    }

                    String tipo = partes[1].trim();
                    String endereco = partes[2].trim();

                    if (tipo.toLowerCase().contains(filtro)) {
                        lista.inserir(new PontoDeDescarte(id, tipo, endereco));
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        lista.exibir();
        lista.limpar(); 
        scanner.close();
    }
}
