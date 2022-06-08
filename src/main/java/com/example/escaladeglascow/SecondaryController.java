package com.example.escaladeglascow;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.edu.unipe.models.EscalaDeComaGlascow;
import br.edu.unipe.models.TestMotor;
import br.edu.unipe.models.TestOcular;
import br.edu.unipe.models.TestVerbal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class SecondaryController implements Initializable{
    
    @FXML
    private ComboBox comboBoxOcular;

    @FXML
    private ComboBox comboBoxVerbal;

    @FXML
    private ComboBox comboBoxMotor;

    @FXML
    private Button butoaFinalizarTeste;

    @FXML
    private Button butaoFazerTesteDeNovo;

    @FXML
    private Label tipoDeTrauma;

    private TestMotor testMotor;

    private TestOcular testOcular;

    private TestVerbal testVerbal;

    private int resultDosTestes = 0;

    private int resultTestOcular =0;

    private int resultTestVerbar =0;

    private int resultTestMotor =0;
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        fazerTesteNovament();
        init();
    }

    private void init() {

        testOcular = new TestOcular();
        testVerbal = new TestVerbal();
        testMotor  = new TestMotor();

        butoaFinalizarTeste.setDisable(true);
        butaoFazerTesteDeNovo.setVisible(false);

        addOptionInTest(testOcular, comboBoxOcular);
        addOptionInTest(testVerbal, comboBoxVerbal);
        addOptionInTest(testMotor, comboBoxMotor);

       finalizarTest();

       enableButoaFinalizarTeste(comboBoxMotor);
       enableButoaFinalizarTeste(comboBoxOcular);
       enableButoaFinalizarTeste(comboBoxVerbal);
    }

    private void enableButoaFinalizarTeste(ComboBox comboBox) {
        comboBox.getSelectionModel().selectedItemProperty().addListener((event) -> {
            butoaFinalizarTeste.setDisable(false);
        });
    }

    private void fazerTesteNovament() {
        butaoFazerTesteDeNovo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                
                restart();
              
            }
            
        });
    }

    private void restart() {
        resultDosTestes = 0;
        tipoDeTrauma.setText("Resultado");
        butoaFinalizarTeste.setDisable(true);
        butaoFazerTesteDeNovo.setVisible(false);
        comboBoxMotor.getSelectionModel().clearSelection();
        comboBoxOcular.getSelectionModel().clearSelection();
        comboBoxVerbal.getSelectionModel().clearSelection();
    }

    private void finalizarTest() {

        butoaFinalizarTeste.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                
               butaoFazerTesteDeNovo.setVisible(true);
                try {
                    resultTestOcular = testOcular.testType(comboBoxOcular.getValue().toString());
                    resultTestVerbar = testVerbal.testType(comboBoxVerbal.getValue().toString());
                    resultTestMotor = testMotor.testType(comboBoxMotor.getValue().toString());
                    
                    resultDosTestes = resultTestMotor + resultTestOcular + resultTestVerbar;
                    System.out.println(resultDosTestes);
        
                    if(resultDosTestes >= 3){
                        EscalaDeComaGlascow escalaDeComaGlascow = new EscalaDeComaGlascow();
                        String reslut = escalaDeComaGlascow.diagnostico(resultDosTestes);
                        tipoDeTrauma.setText(reslut);
                    }
                
                } catch ( Exception e) {
               
                }

               
                
            }
            
        });

    }

    private void addOptionInTest(EscalaDeComaGlascow escalaDeComaGlascow, ComboBox comboBox) {
        ComponentsUI componentsUI = new ComponentsUI(escalaDeComaGlascow);
        ArrayList<String> opcoes = componentsUI.addOptions();
        comboBox.getItems().addAll(opcoes);
    }

}