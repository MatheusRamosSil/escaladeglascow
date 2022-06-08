package br.edu.unipe.models;


import java.util.HashMap;

public class EscalaDeComaGlascow 
{

    private HashMap<String,Integer> escalaDeComa = new HashMap<String,Integer>();



    public EscalaDeComaGlascow() 
    {
        
    }
    
    public HashMap<String, Integer> getEscalaDeComa() 
    {
        return escalaDeComa;
    }

    public void setEscalaDeComa(String key, int value) 
    {
        this.escalaDeComa.put(key, value);
    }
     
    public String diagnostico(int valorDaSomaDaEscala)
    {
        
        if(valorDaSomaDaEscala >= 13 && valorDaSomaDaEscala <= 15)
        {
             return "LEVE";
        }
        else if(valorDaSomaDaEscala >= 9 && valorDaSomaDaEscala <= 12)
        {
             return "MODERADO";
        }
        else if(valorDaSomaDaEscala >= 3 && valorDaSomaDaEscala <= 8)
        {
            return "GRAVE";
        }

        return null;
    } 


    public int testType(String entradaKey) throws InvalidDataInputExcetion 
    {
        
        if(this.getEscalaDeComa().containsKey(entradaKey))
        {
            return this.getEscalaDeComa().get(entradaKey);
        }        
        throw new InvalidDataInputExcetion("Valor inserido é invalido");
    }

}
