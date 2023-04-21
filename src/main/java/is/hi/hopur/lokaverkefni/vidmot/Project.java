package is.hi.hopur.lokaverkefni.vidmot;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import is.hi.hopur.lokaverkefni.vinnsla.Deserialization.DropDownDesirializer;
import is.hi.hopur.lokaverkefni.vinnsla.DropDownGeymsla;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.scene.layout.AnchorPane;
import is.hi.hopur.lokaverkefni.vinnsla.TaskGeymsla;

import java.io.IOException;
@JsonDeserialize(using = DropDownDesirializer.class)
public class Project extends AnchorPane implements JsonSerializable {
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
    @FXML
    private Button fxDeleteProject;
    public TextField getFxTextField() {
        return fxTextField;
    }
    public void setFxTextField(String s) {
        fxTextField.setText(s);
    }
    public void setProgress(double d){
        fxProgressBar.setProgress(d);
    }
    private ObservableList<Project> listi;
    public void setList(ObservableList<Project> list){
        listi = list;
    }
    @FXML
    private TextField fxTextField;
    public Project() {
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
        fxDeleteProject.setOnAction(ActionEvent -> {
            try {
                listi.remove(this);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
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