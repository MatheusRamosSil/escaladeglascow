package com.example.escaladeglascow;

import java.util.ArrayList;

import br.edu.unipe.models.EscalaDeComaGlascow;
import javafx.scene.control.MenuItem;

public class ComponentsUI {
    
    private EscalaDeComaGlascow escalaDeComaGlascow;

    public ComponentsUI(EscalaDeComaGlascow escalaDeComaGlascow) {
        this.escalaDeComaGlascow = escalaDeComaGlascow;
    }



    public ArrayList<String> addOptions(){
        ArrayList<String> opcoes = new ArrayList<String>();
        for(String key : this.escalaDeComaGlascow.getEscalaDeComa().keySet()){
            opcoes.add(key);
        }
        return opcoes;
    }
}
