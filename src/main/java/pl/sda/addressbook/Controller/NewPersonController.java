package pl.sda.addressbook.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.addressbook.Main;
import pl.sda.addressbook.Model.Person;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author fmucko
 */
public class NewPersonController implements Initializable {

    @FXML
    private Button save;
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

    private Person newPerson;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    private boolean filledOut(){
        if(name.getText().equals("")||lastName.getText().equals("")||
                telephone.getText().equals("")||city.getText().equals("")||
                postalCode.getText().equals("")||address.getText().equals("")){
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addNewPerson(){
        if(this.filledOut()){
            newPerson = new Person(name.getText(),lastName.getText(),address.getText(),postalCode.getText(), city.getText(),telephone.getText());
            this.main.getPersonList().add(newPerson);
            Stage stage = (Stage) save.getScene().getWindow();
            stage.close();
        }
    }

    public void cancelAdding(){
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
