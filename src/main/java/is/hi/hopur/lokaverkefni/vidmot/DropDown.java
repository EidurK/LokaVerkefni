package is.hi.hopur.lokaverkefni.vidmot;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import is.hi.hopur.lokaverkefni.vinnsla.Deserialization.DropDownDesirializer;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.scene.layout.AnchorPane;
import is.hi.hopur.lokaverkefni.vinnsla.TaskGeymsla;
import java.io.File;
import java.io.IOException;
@JsonDeserialize(using = DropDownDesirializer.class)
public class DropDown extends AnchorPane implements JsonSerializable {
    public TaskGeymsla getTaskGeymsla() {
        return taskGeymsla;
    }
    public void setTaskGeymsla(TaskGeymsla taskGeymsla) {
        taskGeymsla.getAddTaskButton().getFxAddItemButton().setOnAction(actionEvent ->{
            taskGeymsla.addTask();
        });
        this.taskGeymsla = taskGeymsla;
        fxComboBox.setItems(this.taskGeymsla.getItemObservableList());
        fxProgressBar.progressProperty().bind(this.taskGeymsla.getPercentage());
        this.taskGeymsla.getPercentage().addListener(change -> {
            if (taskGeymsla.getPercentage().getValue() == 1) fxProgressBar.getStyleClass().add("finished");
            else fxProgressBar.getStyleClass().remove("finished");
        }) ;
    }
    private TaskGeymsla taskGeymsla;
    @FXML
    private AnchorPane fxDropDownAnchorPane;
    @FXML
    private ComboBox<AnchorPane> fxComboBox;
    @FXML
    private ProgressBar fxProgressBar;
    public TextField getFxTextField() {
        return fxTextField;
    }
    public void setFxTextField(String s) {
        fxTextField.setText(s);
    }
    public void setProgress(double d){
        fxProgressBar.setProgress(d);
    }
    @FXML
    private TextField fxTextField;
    public DropDown() {
        FXML_Lestur.lesa(this, "dropdown-view.fxml");
        setTaskGeymsla(new TaskGeymsla());
        fxComboBox.setVisibleRowCount(6);
        fxComboBox.setSkin(new ComboBoxListViewSkin<>(fxComboBox) {
            @Override
            public void hide() {
                setHideOnClick(false);
            }
        });
        fxComboBox.selectionModelProperty().set(new SingleSelectionModel<>() {
            @Override
            protected AnchorPane getModelItem(int i) {
                return null;
            }
            @Override
            protected int getItemCount() {
                return 0;
            }
        });
        fxComboBox.setItems(taskGeymsla.getItemObservableList());
    }
    @Override
    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("DropDownText", fxTextField.textProperty().getValue());
        jsonGenerator.writeArrayFieldStart("tasks");
        for(Task t: taskGeymsla.getTaskObservableList()){
            jsonGenerator.writeObject(t);
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
    @Override
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
    }
}