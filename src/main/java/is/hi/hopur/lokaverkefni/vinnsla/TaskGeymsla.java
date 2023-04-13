package is.hi.hopur.lokaverkefni.vinnsla;

import is.hi.hopur.lokaverkefni.vidmot.AddTask;
import is.hi.hopur.lokaverkefni.vidmot.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;

public class TaskGeymsla {
    private ObservableList<AnchorPane> taskObservableList;
    public TaskGeymsla(){
        taskObservableList = FXCollections.observableArrayList();
        AddTask addTaskButton = new AddTask();
        addTaskButton.getFxAddItemButton().setOnAction(actionEvent -> {
            addItem(new Task());
        });
        taskObservableList.add(addTaskButton);
    }
    public void addItem(AnchorPane t){
        taskObservableList.add(t);
    }
    public void addTask(Task t){
        addItem(t);
        t.getFxTextField().setFocusTraversable(true);
    }
    public ObservableList<AnchorPane> getTaskObservableList(){
        return taskObservableList;
    }
}
