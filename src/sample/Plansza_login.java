package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Plansza_login {

    private Plansze planszeController;

    public TextField login;

    public TextField password;

    private boolean logged;

    public void handleZaloguj(ActionEvent actionEvent) throws IOException {

        if (login.getText().equals("user") && password.getText().equals("user")) {
            planszeController.setLabel_login("login:" + login.getText());
            planszeController.setLabel_rola("rola:" + "user");
            planszeController.zmienPlanszaLogin(actionEvent);
        }
        else if (login.getText().equals("admin") && password.getText().equals("admin")) {
                planszeController.setLabel_login("login:" + login.getText());
                planszeController.setLabel_rola("rola:" + "administratir");
                planszeController.zmienPlanszaLogin(actionEvent);
            }
        else  {
                planszeController.setLabel_login("login nieprawidłowy");
                planszeController.setLabel_rola("rola:" + "niezalogowany");
            }
    }


    public void setPlanszeController(Plansze plansze) {

        this.planszeController = plansze;
    }


    public void handleWyloguj(ActionEvent actionEvent) throws IOException {
        planszeController.setLabel_login("");
        planszeController.setLabel_rola("");
        planszeController.zmienPlanszaLogin(actionEvent);

    }
}