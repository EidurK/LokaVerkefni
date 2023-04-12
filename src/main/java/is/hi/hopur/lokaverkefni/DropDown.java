package is.hi.hopur.lokaverkefni;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

public class DropDown extends AnchorPane {

    @FXML
    private AnchorPane fxDropDownAnchorPane;

    @FXML
    private ComboBox fxComboBox;

    @FXML
    private ProgressBar fxProgressBar;

    public DropDown(){
        FXML_Lestur.lesa(this, "dropdown-view.fxml");
    }

    public AnchorPane getFxDropDownAnchorPane() {
        return fxDropDownAnchorPane;
    }

    public ComboBox getFxComboBox() {
        return fxComboBox;
    }

    public ProgressBar getFxProgressBar() {
        return fxProgressBar;
    }

    }
