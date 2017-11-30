package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class Plansza_dane {

    public TableView<Person> table;
    public TextField name;
    public TextField surname;
    public TextField age;
    public TextField pesel;
    public TextField height;
    public TableColumn nameCol;
    public TableColumn surnameCol;
    public TableColumn ageCol;
    public TableColumn peselCol;
    public TableColumn heightCol;

    private Plansze parentController;

    public void setParentController(Plansze parentController) {

        this.parentController = parentController;
    }

    public Plansze getParentController() {

        return parentController;
    }

    private SimpleIntegerProperty index =  new SimpleIntegerProperty();

    public void initialize(){
        nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        surnameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        peselCol.setCellValueFactory(new PropertyValueFactory<Person, String>("pesel"));
        heightCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("height"));

        table.setItems(data);

        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue){
                index.set(data.indexOf(newValue));
                System.out.println("Ok, index in: " + data.indexOf(newValue));
            }
        });
    }


    final ObservableList<Person> data = FXCollections.observableArrayList();


    public void handleClick(ActionEvent actionEvent) {

        Person submit = new Person(name.getText(), surname.getText(), Integer.parseInt(age.getText()),
                pesel.getText(), Integer.parseInt(height.getText()));

        data.add(submit);
    }

    public void onDeleteItem (ActionEvent event) {
        int i = index.get();
        if (i > -1) {
            data.remove(i);
            table.getSelectionModel().clearSelection();
        }

    }
}

