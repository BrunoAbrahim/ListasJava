package org.example;

public class PontoDeDescarte {
    int id;
    String tipoMaterial;
    String endereco;
    PontoDeDescarte proximo;

    // Construtor para inicializar os dados do ponto
    public PontoDeDescarte(int id, String tipoMaterial, String endereco) {
        this.id = id;
        this.tipoMaterial = tipoMaterial;
        this.endereco = endereco;
        this.proximo = null;
    }
}
