package is.hi.hopur.lokaverkefni.vinnsla;

import is.hi.hopur.lokaverkefni.vidmot.AddTask;
import is.hi.hopur.lokaverkefni.vidmot.Task;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

import java.util.concurrent.atomic.AtomicReference;

public class TaskGeymsla {
    private ObservableList<AnchorPane> itemObservableList = FXCollections.observableArrayList();
    private ObservableList<Task> taskObservableList = FXCollections.observableArrayList();

    public double getCheckedPercentage() {
        return checkedPercentage.get();
    }

    public SimpleDoubleProperty checkedPercentageProperty() {
        return checkedPercentage;
    }

    private SimpleDoubleProperty checkedPercentage;
    public TaskGeymsla(){
        checkedPercentage = new SimpleDoubleProperty();
        AddTask addTaskButton = new AddTask();
        addTaskButton.getFxAddItemButton().setOnAction(actionEvent -> {
            addTask(new Task());
        });
        itemObservableList.add(addTaskButton);
    }
    public void addItem(AnchorPane t){
        itemObservableList.add(t);
        if(t.getClass().equals(Task.class)){
            taskObservableList.add((Task) t);
        }
    }
    public void addTask(Task t){
        addItem(t);
    }
    public ObservableList<AnchorPane> getItemObservableList(){
        return itemObservableList;
    }
}
