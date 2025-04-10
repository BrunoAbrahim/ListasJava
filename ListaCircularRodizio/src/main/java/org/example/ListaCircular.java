package org.example;

import java.io.*;

public class ListaCircular {
    private Veiculo inicio = null;

    // Insere um novo veículo na lista circular
    public void inserir(String placa, String dia, String horario) {
        Veiculo novo = new Veiculo(placa, dia, horario);

        if (inicio == null) {
            inicio = novo;
            inicio.proximo = inicio; // Primeiro veículo aponta para ele mesmo
        } else {
            // Insere no final da lista e liga de volta ao início
            Veiculo atual = inicio;
            while (atual.proximo != inicio) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
            novo.proximo = inicio;
        }
    }

    // Carrega dados do arquivo e insere na lista apenas se atender ao filtro
    public void carregarDeArquivo(String nomeArquivo, String criterio) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    String placa = dados[0].trim();
                    String dia = dados[1].trim();
                    String horario = dados[2].trim();
                    // Verifica se o critério bate com o dia ou final da placa
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
        // Percorre e exibe todos os veículos até voltar ao início
        do {
            System.out.println("Placa: " + atual.placa + " | Dia: " + atual.dia + " | Horário: " + atual.horario);
            atual = atual.proximo;
        } while (atual != inicio);
    }
}
