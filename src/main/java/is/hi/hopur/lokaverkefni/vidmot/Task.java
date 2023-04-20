package is.hi.hopur.lokaverkefni.vidmot;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import is.hi.hopur.lokaverkefni.vinnsla.Deserialization.TaskDeserializer;
import is.hi.hopur.lokaverkefni.vinnsla.Deserialization.TaskGeymslaDeserializer;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
@JsonDeserialize(using = TaskDeserializer.class)
public class Task extends AnchorPane implements JsonSerializable {
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
    @Override
    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("text", fxTextField.textProperty().getValue());
        jsonGenerator.writeBooleanField("isChecked", fxCheckBox.isSelected());
        jsonGenerator.writeEndObject();
    }
    @Override
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
    }
}