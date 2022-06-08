package br.edu.unipe.models;

public class TestOcular extends EscalaDeComaGlascow {

    public TestOcular() 
    {
        this.setEscalaDeComa("Espontânea", 4);
        this.setEscalaDeComa("Ao estimulo sonoro", 3);
        this.setEscalaDeComa("Ao estimulo da pressão", 2);
        this.setEscalaDeComa("Nenhuma", 1);
    }
}
