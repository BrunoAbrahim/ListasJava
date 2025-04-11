package org.example;

public class PontoDeDescarte {
    int id;
    String tipoMaterial;
    String endereco;
    PontoDeDescarte proximo;

    public PontoDeDescarte(int id, String tipoMaterial, String endereco) {
        this.id = id;
        this.tipoMaterial = tipoMaterial;
        this.endereco = endereco;
        this.proximo = null;
    }
}
