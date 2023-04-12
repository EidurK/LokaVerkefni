package is.hi.hopur.lokaverkefni;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class TaskView extends AnchorPane{
    @FXML
    private AnchorPane fxTaskAnchor;
    @FXML
    private Label fxLabel;
    @FXML
    private CheckBox fxCheckBox;

    public TaskView(){
        FXML_Lestur.lesa(this, "task-view.fxml");
    }
    public void setLabelText(String s){
        fxLabel.setText(s);
    }
    public AnchorPane getFxTaskAnchor() {
        return fxTaskAnchor;
    }

    public Label getFxLabel() {
        return fxLabel;
    }

    public CheckBox getFxCheckBox() {
        return fxCheckBox;
    }

}
