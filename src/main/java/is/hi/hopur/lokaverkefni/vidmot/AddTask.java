package is.hi.hopur.lokaverkefni.vidmot;

import is.hi.hopur.lokaverkefni.vinnsla.TaskGeymsla;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class AddTask extends AnchorPane {

    @FXML
    private AnchorPane fxAddItemAnchorPane;

    @FXML
    private Button fxAddItemButton;


    public AddTask(){
        FXML_Lestur.lesa(this, "addTask-view.fxml");
    }

    public AnchorPane getFxAddItemAnchorPane() {
        return fxAddItemAnchorPane;
    }

    public Button getFxAddItemButton() {
        return fxAddItemButton;
    }
}
