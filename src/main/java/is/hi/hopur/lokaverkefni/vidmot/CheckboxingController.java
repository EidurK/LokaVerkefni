package is.hi.hopur.lokaverkefni.vidmot;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import is.hi.hopur.lokaverkefni.vinnsla.Deserialization.MainControllerDeserializer;
import is.hi.hopur.lokaverkefni.vinnsla.DropDownGeymsla;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.io.DataInput;
import java.io.File;
import java.io.IOException;
@JsonDeserialize(using = MainControllerDeserializer.class)
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
    public ObservableList<DropDown> getDropDownObservableList() {
        return dropDownObservableList;
    }
    public void setDropDownObservableList(ObservableList<DropDown> dropDownObservableList) {
        this.dropDownObservableList = dropDownObservableList;
    }
    ObservableList<DropDown> dropDownObservableList;
    @FXML
    private void initialize(){
        dropDownObservableList = FXCollections.observableArrayList();
        try{
            dropDownObservableList = objectMapper.readValue(file, this.getClass()).getListItems();
        }catch (Exception e){
            System.out.println("\033[31m" + " Error: " +e.getMessage() + "\033[0m");
        }
        System.out.println(dropDownObservableList.size());
        fxListView.setItems(dropDownObservableList);
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
