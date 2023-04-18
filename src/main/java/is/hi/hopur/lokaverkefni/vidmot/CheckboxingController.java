package is.hi.hopur.lokaverkefni.vidmot;
import is.hi.hopur.lokaverkefni.vinnsla.DropDownGeymsla;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
public class CheckboxingController {
    @FXML
    private ListView<DropDownController> fxListView;
    @FXML
    private Button fxAddProjectButton;
    @FXML
    private void newProjectButtonHandler(ActionEvent event){
        fxListView.getItems().add(new DropDownController());
    }
    private void initialize(){
        DropDownGeymsla dropDownGeymsla = new DropDownGeymsla();
        fxListView.setItems(dropDownGeymsla.getDropDownObservableList());
    }
}