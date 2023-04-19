package is.hi.hopur.lokaverkefni.vidmot;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.scene.layout.AnchorPane;
import is.hi.hopur.lokaverkefni.vinnsla.TaskGeymsla;

import java.io.File;
import java.io.IOException;

public class DropDown extends AnchorPane implements JsonSerializable {
    public TaskGeymsla getTaskGeymsla() {
        return taskGeymsla;
    }

    public void setTaskGeymsla(TaskGeymsla taskGeymsla) {
        this.taskGeymsla = taskGeymsla;
    }

    private TaskGeymsla taskGeymsla;
    private final ObjectMapper objectMapper;
    @FXML
    private AnchorPane fxDropDownAnchorPane;
    @FXML
    private ComboBox<AnchorPane> fxComboBox;
    @FXML
    private ProgressBar fxProgressBar;

    public AnchorPane getFxDropDownAnchorPane() {
        return fxDropDownAnchorPane;
    }
    public ComboBox<AnchorPane> getFxComboBox() {
        return fxComboBox;
    }
    public ProgressBar getFxProgressBar() {
        return fxProgressBar;
    }
    public DropDown() {
        FXML_Lestur.lesa(this, "dropdown-view.fxml");
        objectMapper = new ObjectMapper();
        taskGeymsla = new TaskGeymsla();
        taskGeymsla.getAddTaskButton().getFxAddItemButton().setOnAction(actionEvent ->{
            taskGeymsla.addTask();
        });
        fxComboBox.setVisibleRowCount(6);
        fxComboBox.setSkin(new ComboBoxListViewSkin<>(fxComboBox) {
            @Override
            public void hide() {
                setHideOnClick(false);
            }
        });
        taskGeymsla.getPercentage().addListener(change -> {
            if (taskGeymsla.getPercentage().getValue() == 1) fxProgressBar.getStyleClass().add("finished");
            else fxProgressBar.getStyleClass().remove("finished");
        }) ;
        taskGeymsla.getTaskObservableList().addListener((ListChangeListener<? super Task>) change->  {
            System.out.println("task changed...");
            try {
                objectMapper.writeValue(new File("target/data.json"), this);
            } catch (IOException e) {
                throw new RuntimeException(e);
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
        fxProgressBar.progressProperty().bind(taskGeymsla.getPercentage());
    }

    @Override
    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
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