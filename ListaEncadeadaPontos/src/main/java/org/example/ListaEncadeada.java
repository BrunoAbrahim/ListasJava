package org.example;

public class ListaEncadeada {
    private PontoDeDescarte head; 

    
    public void inserir(PontoDeDescarte ponto) {
        if (head == null) {
            head = ponto; 
        } else {
            PontoDeDescarte atual = head;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = ponto; 
        }
    }

   
    public void exibir() {
        if (head == null) {
            System.out.println("Nenhum ponto de descarte encontrado.");
            return;
        }

        
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
