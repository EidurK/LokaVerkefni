package is.hi.hopur.lokaverkefni.vidmot;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.scene.layout.AnchorPane;
import is.hi.hopur.lokaverkefni.vinnsla.TaskGeymsla;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;

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
        taskGeymsla.getAddTaskButton().getFxAddItemButton().setOnAction(actionEvent ->{
            taskGeymsla.addTask();
        });
        fxComboBox.setVisibleRowCount(6);
        fxComboBox.setSkin(new ComboBoxListViewSkin<>(fxComboBox) {
            @Override
            public void hide() {
                setHideOnClick(false);
            }
        });

        taskGeymsla.getPercentage().addListener(change -> {
            //if (taskGeymsla.getPercentage().getValue() == 1) fxProgressBar.setBackground(Background.fill(Paint.valueOf("#45f574")));
            if (taskGeymsla.getPercentage().getValue() == 1) fxProgressBar.getStyleClass().add("finished");
            else fxProgressBar.getStyleClass().remove("finished");

        }) ;

        fxComboBox.selectionModelProperty().set(new SingleSelectionModel<>() {
            @Override
            protected AnchorPane getModelItem(int i) {
                return null;
            }

            @Override
            protected int getItemCount() {
                return 0;
            }
        });
        fxComboBox.setItems(taskGeymsla.getItemObservableList());
        fxProgressBar.progressProperty().bind(taskGeymsla.getPercentage());
    }
}