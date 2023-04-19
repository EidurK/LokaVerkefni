package is.hi.hopur.lokaverkefni.vidmot;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import is.hi.hopur.lokaverkefni.vinnsla.DropDownGeymsla;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.IOException;

public class CheckboxingController implements JsonSerializable {
  private File file = new File("target/data.json");
  private ObjectMapper objectMapper = new ObjectMapper();
  @FXML
  private ListView<DropDown> fxListView;
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
  private void initialize(){
    DropDownGeymsla dropDownGeymsla = new DropDownGeymsla();
    fxListView.setItems(dropDownGeymsla.getDropDownObservableList());
  }

  @Override
  public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
    jsonGenerator.writeStartObject();
    jsonGenerator.writeArrayFieldStart("DropDowns");
    for(DropDown dropDown: fxListView.getItems()){
      jsonGenerator.writeObject(dropDown);
    }
    jsonGenerator.writeEndArray();
    jsonGenerator.writeEndObject();
  }

  @Override
  public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {

  }
}
