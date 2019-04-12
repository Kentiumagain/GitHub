package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
    @FXML
    public Button btn1;
    @FXML
    private javafx.scene.control.TextArea textarea;
    @FXML
    private javafx.scene.control.TextField textfield;


    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    @FXML
    public void onSendClicked() {
        textarea.setText(textarea.getText().concat(textfield.getText()+"\n"));
        textfield.setText("");
    }
}
