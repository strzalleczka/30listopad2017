package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;



public class Plansze {

    @FXML
    private Label label_login;
    @FXML
    private Label label_rola;
    @FXML
    private Pane plansza;
/*
    public void zmienPlanszaLogin(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("plansza_login.fxml"));
        Parent pane = loader.load();
        Plansza_login cntr = loader.getController();
        cntr.setPlanszeController(this);
        plansza.getChildren().clear();
        plansza.getChildren().add(pane);
    }
*/

    public void zmienPlanszaLogin(ActionEvent actionEvent) throws IOException {
        if (label_login.getText().equals("")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("plansza_login.fxml"));
            Parent pane = loader.load();
            Plansza_login cntr = loader.getController();
            cntr.setPlanszeController(this);
            plansza.getChildren().clear();
            plansza.getChildren().add(pane);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("plansza_logout.fxml"));
            Parent pane = loader.load();
            Plansza_login cntr = loader.getController();
            cntr.setPlanszeController(this);
            plansza.getChildren().clear();
            plansza.getChildren().add(pane);
        }
    }
    public void zmienPlanszaDane(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("plansza_dane.fxml"));
        Parent pane = loader.load();
        plansza.getChildren().clear();
        plansza.getChildren().add(pane);
    }
    public void zmienPlanszaStatystyki(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("plansza_statystyki.fxml"));
        Parent pane = loader.load();
        plansza.getChildren().clear();
        plansza.getChildren().add(pane);
    }

    public void setLabel_login(String nazwa){

        this.label_login.setText(nazwa);
    }

    public void setLabel_rola(String nazwa){

        this.label_rola.setText(nazwa);
    }

}