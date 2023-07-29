package com.example.conversor_azimute_rumo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField aziToRumo;

    @FXML
    private TextField rumoToAzi;

    @FXML
    private Button btnAziToRumo;

    @FXML
    private Button btnRumoToAzi;

    @FXML
    private Label answerLeft;

    @FXML
    private Label answerRight;

    @FXML
    private void onBtnAziToRumoAction() {
        String rumoOutput = convertAzimuteToRumo(aziToRumo.getText());
        answerLeft.setText("Rumo: " + rumoOutput);
    }

    @FXML
    private void onBtnRumoToAziAction() {
        String azimuteOutput = convertRumoToAzimute(rumoToAzi.getText());
        answerRight.setText("Azimute: " + azimuteOutput);
    }

    private String convertAzimuteToRumo(String azimute) {
        String[] split = azimute.split("\\.");
        int minutos;
        int segundos;

        try {
            minutos = Integer.parseInt(split[1]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            minutos = 0;
        }

        try {
            segundos = Integer.parseInt(split[2]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            segundos = 0;
        }

        int grau = Integer.parseInt(split[0]);

        // primeiro quadrante
        if(grau >= 0 && grau < 90) {
            return azimute + ".NE";
        }

        //segundo quadrante
        else if(grau >= 90 && grau < 180) {
            if(grau == 90 && minutos == 0 && segundos == 0) {
                return "90.SE";
            }
            int newGrau = 179 - grau;
            int newMinuto = 59 - minutos;
            int newSegundo = 60 - segundos;

            return String.valueOf(newGrau)+"."+String.valueOf(newMinuto)+"."+String.valueOf(newSegundo)+".SE";
        }

        //terceiro quadrante
        else if(grau >= 180 && grau < 270) {
            int newGrau = grau - 180;
            int newMinuto = minutos;
            int newSEcundo = segundos;

            return String.valueOf(newGrau)+"."+String.valueOf(newMinuto)+"."+String.valueOf(newSEcundo)+".SW";
        }

        // quarto qadrante
        else {
            int newGrau = 359 - grau;
            int newMinuto = 59 - minutos;
            int newSegundo = 60 - segundos;

            return String.valueOf(newGrau)+"."+String.valueOf(newMinuto)+"."+String.valueOf(newSegundo)+".NW";
        }
    }

    private String convertRumoToAzimute(String rumo) {
        String[] split = rumo.split(".");
        return "SALVE";
    }
}