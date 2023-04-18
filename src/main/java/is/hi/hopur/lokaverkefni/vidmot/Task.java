package is.hi.hopur.lokaverkefni.vidmot;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.hi.hopur.lokaverkefni.vinnsla.Deserialization.TaskDeserializer;
import is.hi.hopur.lokaverkefni.vinnsla.Deserialization.TaskSerializer;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
@JsonDeserialize(using = TaskDeserializer.class)
@JsonSerialize(using = TaskSerializer.class)
public class Task extends AnchorPane{
    @FXML
    private TextField fxTextField;
    @FXML
    private CheckBox fxCheckBox;
    public Task() {
        FXML_Lestur.lesa(this, "task-view.fxml");
        this.setFocusTraversable(false);
    }
    public void setLabelText(String s){
        fxTextField.setText(s);
    }
    public CheckBox getFxCheckBox() {
        return fxCheckBox;
    }
    public void setChecked(Boolean b){
        fxCheckBox.selectedProperty().set(b);
    }
}