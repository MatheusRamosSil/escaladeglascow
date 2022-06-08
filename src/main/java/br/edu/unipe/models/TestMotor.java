package br.edu.unipe.models;

public class TestMotor extends EscalaDeComaGlascow
{

    public TestMotor() {
        this.setEscalaDeComa("Obedece comandos", 6);
        this.setEscalaDeComa("Localiza estimulos", 5);
        this.setEscalaDeComa("Flexão normal", 4);
        this.setEscalaDeComa("Flexão anormal", 3);
        this.setEscalaDeComa("Extensão anormal", 2);
        this.setEscalaDeComa("Nenhuma", 1);
    }
}
