package pl.sda.addressbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author fmucko
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/root.fxml"));
        primaryStage.setScene(new Scene(root, 600,290));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
