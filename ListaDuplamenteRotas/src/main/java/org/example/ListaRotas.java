package org.example;

import java.io.*;

public class ListaRotas {
    private Rota cabeca;

    public ListaRotas() {
        this.cabeca = null;
    }

    
    public void inserir(int id, String nome, String tipo, String regiao) {
        Rota nova = new Rota(id, nome, tipo, regiao);
        if (cabeca == null) {
            cabeca = nova; 
        } else {
            Rota atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo; 
            }
            atual.proximo = nova;
            nova.anterior = atual; 
        }
    }

    public void carregarDeArquivo(String nomeArquivo, String filtro) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0].trim());
                    String nome = partes[1].trim();
                    String tipo = partes[2].trim();
                    String regiao = partes[3].trim();

                    if (tipo.equalsIgnoreCase(filtro) || regiao.equalsIgnoreCase(filtro)) {
                        inserir(id, nome, tipo, regiao);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void exibirOrdemNormal() {
        if (cabeca == null) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }

        Rota atual = cabeca;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.proximo;
        }
    }

    public void exibirOrdemInversa() {
        if (cabeca == null) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }

        Rota atual = cabeca;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }

        while (atual != null) {
            System.out.println(atual);
            atual = atual.anterior;
        }
    }

    public void liberar() {
        cabeca = null;
    }
}
