package is.hi.hopur.lokaverkefni;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class TaskView {
    @FXML
    private AnchorPane fxTaskAnchor;
    @FXML
    private Label fxLabel;
    @FXML
    private CheckBox fxCheckBox;

    public TaskView(String labelTexti){
        fxLabel.setText(labelTexti);
    }
}
