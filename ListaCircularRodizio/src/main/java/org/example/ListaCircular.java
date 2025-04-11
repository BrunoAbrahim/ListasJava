package org.example;

import java.io.*;

public class ListaCircular {
    private Veiculo inicio = null;

    public void inserir(String placa, String dia, String horario) {
        Veiculo novo = new Veiculo(placa, dia, horario);

        if (inicio == null) {
            inicio = novo;
            inicio.proximo = inicio; 
        } else {
            Veiculo atual = inicio;
            while (atual.proximo != inicio) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
            novo.proximo = inicio;
        }
    }
    public void carregarDeArquivo(String nomeArquivo, String criterio) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    String placa = dados[0].trim();
                    String dia = dados[1].trim();
                    String horario = dados[2].trim();
                    if (dia.equalsIgnoreCase(criterio) || placa.endsWith(criterio)) {
                        inserir(placa, dia, horario);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("--- Nenhum veículo encontrado com esse critério. ---");
            return;
        }


        System.out.println("\n--- Navegando pela lista circular de veículos ---");
        Veiculo atual = inicio;
        do {
            System.out.println("Placa: " + atual.placa + " | Dia: " + atual.dia + " | Horário: " + atual.horario);
            atual = atual.proximo;
        } while (atual != inicio);
    }
}
