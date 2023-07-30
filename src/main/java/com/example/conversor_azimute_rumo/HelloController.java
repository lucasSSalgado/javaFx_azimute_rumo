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
        if (azimute == "") {
            return "Tax Tola?";
        }
        String[] split = azimute.split("\\.");

        int grau = Integer.parseInt(split[0]);
        int minutos = 0;
        int segundos = 0;

        if (split.length == 2) {
            minutos = Integer.parseInt(split[1]);
        }
        else if(split.length == 3) {
            minutos = Integer.parseInt(split[1]);
            segundos = Integer.parseInt(split[2]);
        }

        // primeiro quadrante
        if(grau >= 0 && grau < 90) {
            return azimute + ".NE";
        }

        //segundo quadrante
        if(grau >= 90 && grau < 180) {
            if(split.length == 1) {
                return 180 - grau + ".SE";
            }
            else if (split.length == 2) {
                int newGrau = 179 - grau;
                int newMinuto = 60 - minutos;
                return newGrau + "." + newMinuto + ".SE";
            }
            else {
                int newGrau = 179 - grau;
                int newMinuto = 59 - minutos;
                int newSegundo = 60 - segundos;

                System.out.println(minutos);

                return newGrau + "." + newMinuto + "." + newSegundo + ".SE";
            }
        }

        //terceiro quadrante
        if(grau >= 180 && grau < 270) {
            if(split.length == 1) {
                return grau - 180 + ".SW";
            }
            else if(split.length == 2) {
                int newGrau = grau - 180;
                int newMinuto = minutos;
                return newGrau + "." + newMinuto + ".SW";
            }
            else {
                int newGrau = grau - 180;
                int newMinuto = minutos;
                int newSEcundo = segundos;

                return newGrau + "." + newMinuto + "." + newSEcundo + ".SW";
            }
        }

        // quarto qadrante
        else {
            if (split.length == 1) {
                return 360 - grau + ".NW";
            }
            if(split.length == 2) {
                int newGrau = 359 - grau;
                int newMinuto = 60 - minutos;
                return newGrau +"."+ newMinuto + ".NW";
            }
            else {
                int newGrau = 359 - grau;
                int newMinuto = 59 - minutos;
                int newSegundo = 60 - segundos;

                return newGrau + "." +newMinuto + "." + newSegundo + ".NW";
            }
        }
    }

    private String convertRumoToAzimute(String rumo) {
        if (rumo == "") {
            return "Tax Tola?";
        }
        String[] split = rumo.split("\\.");

        int grau = Integer.parseInt(split[0]);
        int minutos = 0;
        int segundos = 0;

        if (split.length == 3) {
            minutos = Integer.parseInt(split[1]);
        } else if (split.length == 4) {
            minutos = Integer.parseInt(split[1]);
            segundos = Integer.parseInt(split[2]);
        }

        String direction = split[split.length - 1];
        String directionLowerCase = direction.toLowerCase();

        switch (directionLowerCase) {
            case "ne":
                return rumo;
            case "se":
                if (split.length == 2) {
                    int newGrau = 180 - grau;
                    return newGrau + " SE";
                } else if (split.length == 3) {
                    int newGrau = 179 - grau;
                    int newMinuto = 60 - minutos;
                    return newGrau + "." + newMinuto + " SE";
                } else if (split.length == 4) {
                    int newGrau = 179 - grau;
                    int newMinuto = 59 - minutos;
                    int newSegundos = 60 - segundos;
                    return newGrau + "." + newMinuto + "." + newSegundos + " SE";
                }
            case "sw":
                if (split.length == 2) {
                    int newGrau = 180 + grau;
                    return newGrau + " SE";
                } else if (split.length == 3) {
                    int newGrau = 180 + grau;
                    return newGrau + "." + minutos + " SE";
                } else if (split.length == 4) {
                    int newGrau = 180 + grau;
                    return newGrau + "." + minutos + "." + segundos + " SE";
                }
            case "nw":
                if (split.length == 2) {
                    int newGrau = 360 - grau;
                    return newGrau + " SE";
                } else if (split.length == 3) {
                    int newGrau = 359 - grau;
                    int newMinuto = 60 - minutos;
                    return newGrau + "." + newMinuto + " SE";
                } else if (split.length == 4) {
                    int newGrau = 359 - grau;
                    int newMinuto = 59 - minutos;
                    int newSegundos = 60 - segundos;
                    return newGrau + "." + newMinuto + "." +newSegundos + " SE";
                }
            default:
                System.out.println("Something Wrong");
        }
        return "Something Wrong";
    }
}