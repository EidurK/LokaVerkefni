package is.hi.hopur.lokaverkefni.vinnsla;

import is.hi.hopur.lokaverkefni.vidmot.AddTask;
import is.hi.hopur.lokaverkefni.vidmot.Task;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

import java.util.concurrent.atomic.AtomicReference;

public class TaskGeymsla {
    private ObservableList<AnchorPane> itemObservableList = FXCollections.observableArrayList();
    private ObservableList<Task> taskObservableList = FXCollections.observableArrayList();

    public Double getChecked() {
        return checked.getValue();
    }


    private ObservableValue<Double> checked = new ObservableValueBase<>() {
        @Override
        public Double getValue() {
            if(taskObservableList.isEmpty()){
                return 0.0;
            }
            return Bindings.size((new FilteredList<>(taskObservableList, task -> task.getFxCheckBox().isSelected()))).doubleValue()/Bindings.size(taskObservableList).doubleValue();
        }
    };

    private SimpleDoubleProperty percentage = new SimpleDoubleProperty();
    public SimpleDoubleProperty getPercentage(){
        return percentage;
    }

    public AddTask getAddTaskButton() {
        return addTaskButton;
    }

    private AddTask addTaskButton;

    public TaskGeymsla(){
        addTaskButton = new AddTask();
        itemObservableList.add(addTaskButton);


    }
    public void addItem(AnchorPane t){
        itemObservableList.add(0,t);
        if(t.getClass().equals(Task.class)){
            Task task = (Task) t;
            task.getFxCheckBox().selectedProperty().addListener(c ->{
                percentage.set(getChecked());
            });
            taskObservableList.add(task);
        }
        percentage.set(getChecked());
    }
    public void addTask(){
        addItem(new Task());
    }
    public ObservableList<AnchorPane> getItemObservableList(){
        return itemObservableList;
    }
}
