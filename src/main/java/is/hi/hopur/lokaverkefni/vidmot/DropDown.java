package is.hi.hopur.lokaverkefni.vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import is.hi.hopur.lokaverkefni.vinnsla.TaskGeymsla;

public class DropDown extends AnchorPane {

    @FXML
    private AnchorPane fxDropDownAnchorPane;

    @FXML
    private ComboBox<Task> fxComboBox;

    @FXML
    private ProgressBar fxProgressBar;


    public AnchorPane getFxDropDownAnchorPane() {
        return fxDropDownAnchorPane;
    }

    public ComboBox<Task> getFxComboBox() {
        return fxComboBox;
    }

    public ProgressBar getFxProgressBar() {
        return fxProgressBar;
    }
    public DropDown(){
        FXML_Lestur.lesa(this, "dropdown-view.fxml");
        TaskGeymsla taskGeymsla = new TaskGeymsla();
        fxComboBox.setItems(taskGeymsla.getTaskObservableList());
    }

    }
