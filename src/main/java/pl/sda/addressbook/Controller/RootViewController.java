package pl.sda.addressbook.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pl.sda.addressbook.Main;
import pl.sda.addressbook.Model.Person;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author fmucko
 */
public class RootViewController implements Initializable {

    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person, String> nameCol;
    @FXML
    private TableColumn<Person, String> lastNameCol;
    @FXML
    private Label name;
    @FXML
    private Label lastName;
    @FXML
    private Label address;
    @FXML
    private Label telephone;
    @FXML
    private Label city;
    @FXML
    private Label postalCode;
    @FXML
    private Button newPerson;
    @FXML
    private Button edit;
    @FXML
    private Button save;
    @FXML
    private Button delete;

    private Main main;
    private Person currentPerson;

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void refreshData() {
        if (currentPerson != null) {
            this.lastName.setText(currentPerson.getLastName());
            this.name.setText(currentPerson.getName());
            this.address.setText(currentPerson.getAddress());
            this.city.setText(currentPerson.getCity());
            this.postalCode.setText(currentPerson.getPostalCode());
            this.telephone.setText(currentPerson.getTelephone());
        }
    }

    public void loadPerson() {
        personTableView.setItems(this.main.getPersonList());
        nameCol.setCellValueFactory(c -> c.getValue().nameProperty());
        lastNameCol.setCellValueFactory(c -> c.getValue().lastNameProperty());
    }

    public void showSelectedPerson() {
        try {
            this.currentPerson = personTableView.getSelectionModel().getSelectedItem();
            this.refreshData();
        } catch (NullPointerException e) {
            System.out.println("empty");
        }
    }

    public void deleteCurrentPerson() {
        if (currentPerson != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                personTableView.getItems().remove(currentPerson);
                currentPerson = null;
            }
        }
    }

    public void addNewPerson() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/newPerson.fxml"));
            loader.load();
            Parent root = loader.getRoot();
            NewPersonController newPersonController = loader.getController();
            newPersonController.setMain(this.main);
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root, 600, 400));
            newStage.setResizable(false);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editRecord() {
        if (currentPerson != null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/editPerson.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                EditPersonController editPersonController = loader.getController();
                editPersonController.setMain(this.main);
                editPersonController.setCurrentPerson(this.currentPerson);
                editPersonController.setRootViewController(this);
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root, 600, 400));
                newStage.setResizable(false);
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
