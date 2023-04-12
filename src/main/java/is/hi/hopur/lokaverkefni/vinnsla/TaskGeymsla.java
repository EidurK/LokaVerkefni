package is.hi.hopur.lokaverkefni.vinnsla;

import is.hi.hopur.lokaverkefni.vidmot.Task;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

public class TaskGeymsla {
    private ObservableList<Task> taskObservableList;
    public TaskGeymsla(){
        taskObservableList = new SimpleListProperty<>();
    }
    public void addTask(Task t){
        taskObservableList.add(t);
    }
    public ObservableList<Task> getTaskObservableList(){
        return taskObservableList;
    }
}
