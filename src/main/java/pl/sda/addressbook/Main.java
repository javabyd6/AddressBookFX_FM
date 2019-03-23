package pl.sda.addressbook;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.Controller.RootViewController;
import pl.sda.addressbook.Model.Person;

/**
 * @author fmucko
 */
public class Main extends Application {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public Main(){
        personList.add(new Person("Jan", "Kowalski", "adres", "00-000", "Bydgoszcz",
                "999999999"));
        personList.add(new Person("Pan", "Powalski", "address", "01-000", "Brzydgoszcz",
                "9877899999"));
    }

    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Parent root = FXMLLoader.load(getClass().getResource("/root.fxml"));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/root.fxml"));
        loader.load();

        Parent root = loader.getRoot();
        RootViewController rootViewController = loader.getController();
        rootViewController.setMain(this);
        rootViewController.loadPerson();

        primaryStage.setScene(new Scene(root, 590,290));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
