package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller ctrl = loader.getController();
        ctrl.setPrimaryStage(primaryStage);

        primaryStage.setTitle("Чат");
        primaryStage.setScene(new Scene(root, 420, 450));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
