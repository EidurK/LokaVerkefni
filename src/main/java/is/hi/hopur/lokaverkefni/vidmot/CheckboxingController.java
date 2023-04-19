package is.hi.hopur.lokaverkefni.vidmot;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import is.hi.hopur.lokaverkefni.vinnsla.DropDownGeymsla;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
public class CheckboxingController {
  private ObjectMapper objectMapper = new ObjectMapper();
  @FXML
  private ListView<DropDown> fxListView;
  @FXML
  private Button fxAddProjectButton;
  @FXML
  private void newProjectButtonHandler(ActionEvent event) throws JsonProcessingException {
    DropDown d = new DropDown();
    objectMapper.writeValueAsString(d);
    fxListView.getItems().add(d);
  }
  private void initialize(){
    DropDownGeymsla dropDownGeymsla = new DropDownGeymsla();
    fxListView.setItems(dropDownGeymsla.getDropDownObservableList());
  }
}
