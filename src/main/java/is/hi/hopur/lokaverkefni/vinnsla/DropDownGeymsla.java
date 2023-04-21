package is.hi.hopur.lokaverkefni.vinnsla;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import is.hi.hopur.lokaverkefni.vidmot.Project;
import is.hi.hopur.lokaverkefni.vinnsla.Deserialization.DropDownGeymslaDeserializer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
@JsonDeserialize(using = DropDownGeymslaDeserializer.class)
public class DropDownGeymsla {
    private ObservableList<Project> dropDownObservableList;
    public DropDownGeymsla(){
        dropDownObservableList = FXCollections.observableArrayList();
    }
    public void remove(Project d){
        dropDownObservableList.remove(d);
    }
    public ObservableList<Project> getDopDownGeymsla() {
        return dropDownObservableList;
    }
    public void setDropDownGeymsla(ObservableList<Project> od){
        dropDownObservableList = od;
    }
    public void addDropDown(Project d){

        dropDownObservableList.add(d);

    }
}
