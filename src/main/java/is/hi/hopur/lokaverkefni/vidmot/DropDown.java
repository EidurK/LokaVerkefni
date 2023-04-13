package is.hi.hopur.lokaverkefni.vidmot;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.scene.layout.AnchorPane;
import is.hi.hopur.lokaverkefni.vinnsla.TaskGeymsla;
public class DropDown extends AnchorPane  {
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
    public DropDown(){
        FXML_Lestur.lesa(this, "dropdown-view.fxml");
        TaskGeymsla taskGeymsla = new TaskGeymsla();

        fxComboBox.setSkin(new ComboBoxListViewSkin<AnchorPane>(fxComboBox){
            @Override
            public void hide() {
              setHideOnClick(false);
            }
        });
        fxComboBox.setItems(taskGeymsla.getItemObservableList());
        fxProgressBar.progressProperty().bind(taskGeymsla.getPercentage());
    }
}