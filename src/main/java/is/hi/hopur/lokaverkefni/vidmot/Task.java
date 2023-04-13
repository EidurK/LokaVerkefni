package is.hi.hopur.lokaverkefni.vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Task extends AnchorPane{
    @FXML
    private AnchorPane fxTaskAnchor;
    @FXML
    private TextField fxTextField;
    @FXML
    private CheckBox fxCheckBox;

    public Task(){
        FXML_Lestur.lesa(this, "task-view.fxml");
        this.setId("task");
        this.setFocusTraversable(false);
    }
    public void setLabelText(String s){
        fxTextField.setText(s);
    }
    public AnchorPane getFxTaskAnchor() {
        return fxTaskAnchor;
    }

    public TextField getFxTextField() {
        return fxTextField;
    }

    public CheckBox getFxCheckBox() {
        return fxCheckBox;
    }


}
