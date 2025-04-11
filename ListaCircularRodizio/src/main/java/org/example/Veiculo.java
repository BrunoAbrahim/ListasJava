package org.example;

public class Veiculo {
    String placa;
    String dia;
    String horario;
    Veiculo proximo;
    
    public Veiculo(String placa, String dia, String horario) {
        this.placa = placa;
        this.dia = dia;
        this.horario = horario;
        this.proximo = null;
    }
}
