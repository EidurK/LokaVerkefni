package is.hi.hopur.lokaverkefni;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CheckboxingController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}