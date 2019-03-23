package pl.sda.addressbook.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.addressbook.Main;
import pl.sda.addressbook.Model.Person;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author fmucko
 */
public class EditPersonController implements Initializable {

    @FXML
    private Button edit;
    @FXML
    private Button cancel;
    @FXML
    private TextField name;
    @FXML
    private TextField lastName;
    @FXML
    private TextField telephone;
    @FXML
    private TextField city;
    @FXML
    private TextField postalCode;
    @FXML
    private TextField address;

    private Person currentPerson;
    private Main main;
    private RootViewController rootViewController;

    public void setRootViewController(RootViewController rootViewController) {
        this.rootViewController = rootViewController;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    private boolean filledOut() {
        if (name.getText().equals("") || lastName.getText().equals("") ||
                telephone.getText().equals("") || city.getText().equals("") ||
                postalCode.getText().equals("") || address.getText().equals("")) {
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void editPerson() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (this.filledOut() && this.currentPerson != null && alert.getResult() == ButtonType.YES) {
            this.currentPerson.setName(name.getText());
            this.currentPerson.setLastName(lastName.getText());
            this.currentPerson.setAddress(address.getText());
            this.currentPerson.setPostalCode(postalCode.getText());
            this.currentPerson.setCity(city.getText());
            this.currentPerson.setTelephone(telephone.getText());
            this.rootViewController.refreshData();

            Stage stage = (Stage) edit.getScene().getWindow();
            stage.close();
        }
    }

    public void cancelAdding() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;

        this.address.setText(currentPerson.getAddress());
        this.name.setText(currentPerson.getName());
        this.lastName.setText(currentPerson.getLastName());
        this.telephone.setText(currentPerson.getTelephone());
        this.city.setText(currentPerson.getCity());
        this.postalCode.setText(currentPerson.getPostalCode());
    }
}
