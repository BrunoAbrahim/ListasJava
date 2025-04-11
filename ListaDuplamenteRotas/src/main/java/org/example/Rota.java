package org.example;

public class Rota {
    int id;
    String nomeLinha;
    String tipoTransporte;
    String regiao;

    Rota anterior;
    Rota proximo;

    
    public Rota(int id, String nomeLinha, String tipoTransporte, String regiao) {
        this.id = id;
        this.nomeLinha = nomeLinha;
        this.tipoTransporte = tipoTransporte;
        this.regiao = regiao;
        this.anterior = null;
        this.proximo = null;
    }

    @Override
    public String toString() {
        return id + " - " + nomeLinha + " [" + tipoTransporte + "] (" + regiao + ")";
    }
}
