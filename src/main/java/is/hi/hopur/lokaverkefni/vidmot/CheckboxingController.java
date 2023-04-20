package is.hi.hopur.lokaverkefni.vidmot;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import is.hi.hopur.lokaverkefni.vinnsla.DropDownGeymsla;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.io.File;
import java.io.IOException;
public class CheckboxingController implements JsonSerializable {
    private File file = new File("target/data.json");
    private ObjectMapper objectMapper = new ObjectMapper();
    public ObservableList<DropDown> getListItems(){
        return fxListView.getItems();
    }
    public void setListItems(ObservableList<DropDown> observableList){
        fxListView.setItems(observableList);
    }
    @FXML
    private ListView<DropDown> fxListView;
    @FXML
    private Button fxSaveProjectButton;
    @FXML
    private Button fxAddProjectButton;
    @FXML
    private void newProjectButtonHandler(ActionEvent event) throws JsonProcessingException {
        fxListView.getItems().add(new DropDown());
    }
    @FXML
    private void saveProjectButtonHandler(ActionEvent event) throws IOException {
        objectMapper.writeValue(file, this);
    }
    public DropDownGeymsla dropDownGeymsla() {
        return dropDownGeymsla;
    }
    public void setDropDownGeymsla(DropDownGeymsla g) {
        dropDownGeymsla = g;
    }
    private DropDownGeymsla dropDownGeymsla;
    @FXML
    private void initialize(){
        dropDownGeymsla = new DropDownGeymsla();
        try{
            dropDownGeymsla = objectMapper.readValue(file, dropDownGeymsla.getClass());
            count(dropDownGeymsla);
        }catch (Exception e){
            System.out.println("\033[31m" + " Error: " +e.getMessage() + "\033[0m");
        }
        count(dropDownGeymsla);
        fxListView.setItems(dropDownGeymsla.getDopDownGeymsla());
    }
    private static void count(DropDownGeymsla dropDownGeymsla){
        for(DropDown drop: dropDownGeymsla.getDopDownGeymsla()){
            System.out.println("doropDown");
            for(Task task: drop.getTaskGeymsla().getTaskObservableList()){
                System.out.println("task");
            }
        }

    }
    @Override
    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeArrayFieldStart("DropDowns");
        for(DropDown dropDown: getListItems()){
            jsonGenerator.writeObject(dropDown);
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
    @Override
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
    }
}
