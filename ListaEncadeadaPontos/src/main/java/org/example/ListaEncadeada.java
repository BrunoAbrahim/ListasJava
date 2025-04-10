package org.example;

public class ListaEncadeada {
    private PontoDeDescarte head; // Referência para o primeiro nó da lista

    // Insere um novo ponto no final da lista
    public void inserir(PontoDeDescarte ponto) {
        if (head == null) {
            head = ponto; // Se a lista estiver vazia, insere no início
        } else {
            // Percorre até o final da lista
            PontoDeDescarte atual = head;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = ponto; // Adiciona o novo nó no final
        }
    }

    // Exibe todos os pontos armazenados na lista
    public void exibir() {
        if (head == null) {
            System.out.println("Nenhum ponto de descarte encontrado.");
            return;
        }

        // Mostra os dados formatados do ponto
        System.out.println("\nPontos de Coleta:");
        PontoDeDescarte atual = head;
        while (atual != null) {
            System.out.printf("ID: %d | Tipo: %s | Endereço: %s%n",
                    atual.id, atual.tipoMaterial, atual.endereco);
            atual = atual.proximo;
        }
    }

    public void limpar() {
        head = null;
    }
}
