package is.hi.hopur.lokaverkefni.vidmot;

import is.hi.hopur.lokaverkefni.vinnsla.DropDownGeymsla;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class CheckboxingController {
    @FXML
    private ListView fxListView;

    @FXML
    private Button fxAddProjectButton;


    private void initialize(){
        DropDownGeymsla dropDownGeymsla = new DropDownGeymsla();
        fxListView.setItems(dropDownGeymsla.getDropDownObservableList());
    }



}
